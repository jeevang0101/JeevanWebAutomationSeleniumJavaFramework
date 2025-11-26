package com.demo.utils;

import com.demo.variables.Env;

import java.util.Properties;

public class ConfigReader {
    private final Properties properties;
    private static ConfigReader configReader;

    private ConfigReader(){
        String env = System.getProperty("env", Env.PROD.env); // default env => PROD
        switch (env){
            case "prod":
                properties = PropertyUtils.loadProperties("src/test/resources/prod_config.properties");
                break;
            case "stage":
                properties = PropertyUtils.loadProperties("src/test/resources/stage_config.properties");
                break;
            default:
                throw new IllegalStateException("Invalid Environment : " + env);
        }
    }

    public static ConfigReader getConfigReader(){
        if(configReader == null){
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getProperty(String property){
        String propertyValue = properties.getProperty(property);
        if(propertyValue == null){
            throw  new RuntimeException(property + " is not specified in prod_config.properties file");
        }
        return propertyValue;
    }
}
