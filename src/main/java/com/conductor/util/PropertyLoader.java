package com.conductor.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {


    private static final Properties applicationProperties;

    static {
        applicationProperties = new Properties();
        try {
            applicationProperties.load(new FileReader(ClassLoader.getSystemResource("application.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyLoader() {
    }

    public static String getProperty(String property) {
        return applicationProperties.getProperty(property);
    }

    public static String getBeaconURL() {
        return getProperty("beacon.endpoint");
    }

    public static Integer getOutputValueLength() {
        return Integer.valueOf(getProperty("beacon.outputValueLength"));
    }

    public static String getHexAllowedChars() {
        return getProperty("beacon.getHexAllowedChars");
    }
}
