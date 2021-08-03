package eu.org.xmon.emojishortenurl.utils;

import java.net.URL;

public class OtherUtils {
    public static boolean isURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
