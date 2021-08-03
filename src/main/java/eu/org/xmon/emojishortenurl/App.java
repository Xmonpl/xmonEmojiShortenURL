package eu.org.xmon.emojishortenurl;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import dev.walshy.sparkratelimiter.RateLimiter;
import eu.org.xmon.emojishortenurl.config.ConfigHolder;
import eu.org.xmon.emojishortenurl.manager.ShortManager;
import eu.org.xmon.emojishortenurl.utils.LoggerUtils;
import eu.org.xmon.emojishortenurl.utils.RoutesUtils;
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

    public void startUp(){
        //Setup logger
        final LoggerUtils loggerUtils = new LoggerUtils();
        loggerUtils.start();

        final ShortManager shortManager = new ShortManager();
        shortManager.loadUsers();
        Runtime.getRuntime().addShutdownHook(new Thread(() ->{
            try {
                shortManager.saveUrls();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        LoggerUtils.logger.info("Initialization config file..");
        final File configFile = new File("config.yml");
        if (!configFile.exists()){
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final SettingsManager config = SettingsManagerBuilder
                .withYamlFile(configFile)
                .configurationData(ConfigHolder.class)
                .useDefaultMigrationService()
                .create();

        LoggerUtils.logger.info("Initialization ratelimiter..");
        final RateLimiter rateLimiter = new RateLimiter(config.getProperty(ConfigHolder.SETTINGS_MAX$REQUESTS), config.getProperty(ConfigHolder.SETTINGS_RATELIMITS$RESET), TimeUnit.MINUTES);

        LoggerUtils.logger.info("Running web server on http://localhost:" + config.getProperty(ConfigHolder.SETTINGS_PORT));
        port(config.getProperty(ConfigHolder.SETTINGS_PORT));

        LoggerUtils.logger.info("Initialization all routes..");
        notFound((request, response) -> RoutesUtils.error404(config));

        internalServerError((request, response) -> RoutesUtils.error404(config));

        staticFiles.location("/public");

        exception(Exception.class, (exception, req, res) -> exception.printStackTrace());

        rateLimiter.map("/api/v1/*");

        post("/api/v1/short", (request, response) -> RoutesUtils.POST$SHORTURL(request, response, config));

        get("/", (request, response) -> RoutesUtils.index(request, response, config));

        get("/:id", (request, response) ->  RoutesUtils.GET$SHORTURL(request, response, config));
    }
}
