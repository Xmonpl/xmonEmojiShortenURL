package eu.org.xmon.emojishortenurl.config;

import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

public class ConfigHolder implements SettingsHolder {
    public static final Property<Integer> SETTINGS_MAX$REQUESTS
            = newProperty("settings.max$requests", 30);

    public static final Property<Integer> SETTINGS_RATELIMITS$RESET
            = newProperty("settings.ratelimits$reset", 1);

    public static final Property<Integer> SETTINGS_PORT
            = newProperty("settings.port", 8082);

    public static final Property<String> SETTINGS_TITLE$PREFIX
            = newProperty("settings.title$prefix", "v.Xmon.eu.org ☕ ");

    public static final Property<String> SETTINGS_URL
            = newProperty("settings.url", "https://v.Xmon.eu.org/");

    private ConfigHolder(){}
}
