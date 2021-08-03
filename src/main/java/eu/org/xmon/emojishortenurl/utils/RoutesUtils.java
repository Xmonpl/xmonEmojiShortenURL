package eu.org.xmon.emojishortenurl.utils;

import ch.jalu.configme.SettingsManager;
import eu.org.xmon.emojishortenurl.config.ConfigHolder;
import eu.org.xmon.emojishortenurl.manager.ShortManager;
import eu.org.xmon.emojishortenurl.object.Short;
import org.json.JSONObject;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RoutesUtils {
    public static String error404(final SettingsManager config){
        final Map<String, Object> model = new HashMap<>();
        model.put("titleprefix", config.getProperty(ConfigHolder.SETTINGS_TITLE$PREFIX));
        model.put("url", config.getProperty(ConfigHolder.SETTINGS_URL));
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "private/404-error.ftl")
        );
    }

    public static String index(final Request request, final Response response, final SettingsManager config){
        final Map<String, Object> model = new HashMap<>();
        model.put("titleprefix", config.getProperty(ConfigHolder.SETTINGS_TITLE$PREFIX));
        model.put("url", config.getProperty(ConfigHolder.SETTINGS_URL));
        return new VelocityTemplateEngine().render(
                new ModelAndView(model, "private/index.ftl")
        );
    }

    public static String GET$SHORTURL(final Request req, final Response res, final SettingsManager config){
        if (req.params("id") == null){
            res.status(404);
            return null;
        }else{
            final Optional<Short> shortURL = ShortManager.getShortByEmojiURL(req.params("id"));
            if (shortURL.isEmpty()){
                res.status(404);
                return null;
            }else{
                res.redirect(shortURL.get().getOrginal$url(), 301);
                return "<!DOCTYPE html><html><head><meta http-equiv=\"refresh\" content=\"0; url=" + shortURL.get().getOrginal$url() + "\"></head><body<script>window.location.replace(\">" + shortURL.get().getOrginal$url() + "\");</script></body></html>";
            }
        }
    }

    public static String POST$SHORTURL(final Request req, final Response res, final SettingsManager config){
        res.header("Content-Type", "application/json;charset=UTF-8;");
        final JSONObject obj = new JSONObject();
        if (req.queryParams("url") == null || req.queryParams("size") == null){
            res.status(400);
            obj.put("success", false);
            obj.put("data", "URL or Emoji size is empty.");
        }else{
            if (!OtherUtils.isURL(req.queryParams("url"))){
                res.status(400);
                obj.put("success", false);
                obj.put("data", "URL isn't a valid url.");
            }else{
                try{
                    final Integer emojiSize = Integer.valueOf(req.queryParams("size"));
                    final Short shortURL = ShortManager.createShortURL(req.queryParams("url"), emojiSize);
                    res.status(200);
                    obj.put("success", true);
                    obj.put("data", config.getProperty(ConfigHolder.SETTINGS_URL) + "/" + shortURL.getEmoji$url());
                }catch (Exception e){
                    res.status(400);
                    obj.put("success", false);
                    obj.put("data", "Emoji size isn't a valid integer.");
                }
            }
        }
        return obj.toString();
    }
}
