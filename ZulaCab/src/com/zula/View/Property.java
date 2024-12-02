package com.zula.View;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    public static void main(String[] args) {
         Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("application.properties")) {
            properties.load(input);

            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String appName = properties.getProperty("app.name");
            String appVersion = properties.getProperty("app.version");

            System.out.println("Database URL: " + dbUrl);
            System.out.println("Database Username: " + dbUsername);
            System.out.println("Database Password: " + dbPassword);
            System.out.println("App Name: " + appName);
            System.out.println("App Version: " + appVersion);
        } catch (IOException e) {
        }
    }
}
