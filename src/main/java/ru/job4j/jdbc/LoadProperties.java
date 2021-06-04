package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private static final Properties PROPERTIES = new Properties();
    private static final LoadProperties LOAD_PROPERTIES = new LoadProperties();

    private LoadProperties() {
        ClassLoader classLoader = LoadProperties.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("app.properties")) {
            PROPERTIES.load(inputStream);
            LOG.debug("Load app.properties");
        } catch (Exception e) {
            LOG.error("Error message:", e);
        }
    }

    public static Properties getProperties() {
        return PROPERTIES;
    }
}
