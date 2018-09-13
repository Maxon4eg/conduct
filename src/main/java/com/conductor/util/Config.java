package com.conductor.util;

public class Config {
    private static String beaconURL = System.getProperty("beacon.endpoint");
    private static Integer outputValueLength = Integer.parseInt(System.getProperty("beacon.outputValueLength"));
    private static String hexAllowedChars = System.getProperty("beacon.outputAlowedCharactersPattern");

    public static String getBeaconURL() {
        return beaconURL;
    }

    public static int getOutputValueLength() {
        return outputValueLength;
    }

    public static String getHexAllowedChars() {
        return hexAllowedChars;
    }
}
