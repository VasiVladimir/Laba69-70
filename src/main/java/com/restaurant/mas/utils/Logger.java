package com.restaurant.mas.utils;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String LOG_FILE = "logs.txt";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(message + "\n");
            System.out.println(message);
        } catch (IOException e) {
            System.err.println("Failed to log message: " + message);
        }
    }
}
