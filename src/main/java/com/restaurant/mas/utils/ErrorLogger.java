package com.restaurant.mas.utils;

import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {
    private static final String ERROR_FILE = "errors.txt";

    public static void logError(String entity, String field, String description) {
        String errorMessage = String.format("{\"error\": {\"entity\": \"%s\", \"field\": \"%s\", \"description\": \"%s\"}}",
                entity, field, description);
        try (FileWriter writer = new FileWriter(ERROR_FILE, true)) {
            writer.write(errorMessage + "\n");
            System.err.println("Error logged: " + errorMessage);
        } catch (IOException e) {
            System.err.println("Failed to log error: " + errorMessage);
        }
    }
}
