package util;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {

    private PropertiesUtil() {
    }

    private static final Properties PROPERTIES = new Properties();

    static {
        try (var resourceAsStream = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
        PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
