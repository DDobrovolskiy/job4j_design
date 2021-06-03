package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.InputStream;

public class AppProperties {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private Settings settings;

    public AppProperties() {
        settings = new Settings();
        ClassLoader classLoader = Settings.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("app.properties")) {
            settings.load(inputStream);
            LOG.trace("Load resource : app.properties");
        } catch (Exception e) {
            LOG.error("Error message:", e);
        }
    }

    public String getValue(String key) {
        return this.settings.getValue(key);
    }
}
