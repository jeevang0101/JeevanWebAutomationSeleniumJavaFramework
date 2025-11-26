package com.demo.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(bufferedReader);
                bufferedReader.close();
            } catch ( IOException e) {
                throw new RuntimeException("Failed to load properties file : " + filePath);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found at : " + filePath);
        }
        return properties;
    }
}
