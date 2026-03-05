package com.ui.selenium.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("config properties was not found");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("config properties was not loaded", e);
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "edge");
    }
}
