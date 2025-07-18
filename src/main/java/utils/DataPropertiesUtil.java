package utils;

import properties.FilePropertiesReader;

import java.io.IOException;
import java.util.Map;

public class DataPropertiesUtil {
    private final Map<String, String> data;

    {

        try {
            data = new FilePropertiesReader().getData();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }

    }

    public String getEmailFromProperties() {
        return data.get("email");
    }

    public String getPasswordFromProperties() {
        return data.get("password");
    }
}
