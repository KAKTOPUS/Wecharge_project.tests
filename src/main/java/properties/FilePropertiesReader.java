package properties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FilePropertiesReader implements IPropertiesReader {

    @Override
    public Map<String, String> getData() throws IOException {
        Properties properties = new Properties();
        properties.load(Files.newInputStream(Paths.get(System.getProperty("user.dir") + "/src/main/resources/data.properties")));

        Map<String, String> data = new HashMap<>();

        for (String key : properties.stringPropertyNames()) {
            data.put(key, properties.getProperty(key));
        }

        return data;
    }
}