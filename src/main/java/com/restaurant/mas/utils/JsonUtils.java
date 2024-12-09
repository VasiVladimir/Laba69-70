package com.restaurant.mas.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonFile(String filePath, Class<T> clazz) throws IOException {
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (Exception e) {
            ErrorLogger.logError(filePath, "file_format", "Invalid JSON format or structure");
            throw e;
        }
    }


    public static void writeJsonFile(String filePath, Object data) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
    }
}
