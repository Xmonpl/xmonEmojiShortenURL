package eu.org.xmon.emojishortenurl;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import dev.walshy.sparkratelimiter.RateLimiter;
import eu.org.xmon.emojishortenurl.config.ConfigHolder;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.*;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    public void startUp(){
        //Setup logger
        System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
        logger.setLevel(Level.ALL);
        try {
            new File("logs").mkdir();
            FileHandler fileHandler = new FileHandler("/logs/log-%u.log", 1000 * 1000 * 20, 100, true);
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
            return;
        }

        logger.info("Initialization config file..");
        final SettingsManager config = SettingsManagerBuilder
                .withYamlFile(new File("config.yml"))
                .configurationData(ConfigHolder.class)
                .useDefaultMigrationService()
                .create();

        logger.info("Initialization ratelimiter..");
        final RateLimiter rateLimiter = new RateLimiter(config.getProperty(ConfigHolder.SETTINGS_MAX$REQUESTS), config.getProperty(ConfigHolder.SETTINGS_RATELIMITS$RESET), TimeUnit.MINUTES);

        logger.info("Running web server on http://localhost:" + config.getProperty(ConfigHolder.SETTINGS_PORT));
        port(config.getProperty(ConfigHolder.SETTINGS_PORT));
        notFound((request, response) -> {
            final Map<String, Object> model = new HashMap<>();
            model.put("titleprefix", config.getProperty(ConfigHolder.SETTINGS_TITLE$PREFIX));
            model.put("url", config.getProperty(ConfigHolder.SETTINGS_URL));
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "private/404-error.ftl")
            );
        });

        internalServerError((request, response) -> {
            final Map<String, Object> model = new HashMap<>();
            model.put("titleprefix", config.getProperty(ConfigHolder.SETTINGS_TITLE$PREFIX));
            model.put("url", config.getProperty(ConfigHolder.SETTINGS_URL));
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "private/404-error.ftl")
            );
        });

        staticFiles.location("/public");

        exception(Exception.class, (exception, req, res) -> exception.printStackTrace());

        rateLimiter.map("/api/v1/*");

        get("/", (request, response) -> {
            final Map<String, Object> model = new HashMap<>();
            return null;
        });
    }
}
