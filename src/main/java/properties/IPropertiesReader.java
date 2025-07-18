package properties;

import java.io.IOException;
import java.util.Map;

public interface IPropertiesReader {
    Map<String, String> getData() throws IOException;
}
