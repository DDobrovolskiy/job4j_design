package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.UsageLog4j;

import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    private final Properties properties = new Properties();

    public void load(InputStream inputStream) {
        try {
            this.properties.load(inputStream);
        } catch (Exception e) {
            LOG.error("Error message:", e);
        }
    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}