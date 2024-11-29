package com.zula.Controller;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerController {

    private static final Logger logger = Logger.getLogger(LoggerController.class.getName());

    public static boolean initialize() {
        try {
            FileHandler fileHandler = new FileHandler("application.log",true);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            
            logger.addHandler(fileHandler);

            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }


    public static void info(String message) {
        logger.info(message);     
    }
    public static void warning(String message) {
        logger.warning(message);     
    }
    public static void log(String message) {
        logger.info(message);     
    }
    public static void severe(String message) {
        logger.severe(message);  
    }
}
