package eu.org.xmon.emojishortenurl.utils;

import eu.org.xmon.emojishortenurl.App;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtils {
    public static Logger logger = Logger.getLogger(App.class.getName());

    public void start(){
        System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
        logger.setLevel(Level.ALL);
        try {
            new File("logs").mkdir();
            FileHandler fileHandler = new FileHandler("log-%u.log", 1000 * 1000 * 20, 100, true);
            logger.addHandler(fileHandler);
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
            return;
        }
    }
}
