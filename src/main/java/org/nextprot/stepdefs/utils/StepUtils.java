package org.nextprot.stepdefs.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StepUtils {

    private static final Properties properties;

    private StepUtils() {
        throw new IllegalAccessError("not instanciable");
    }

    static {
        try {
            properties = loadProperties(
                    StepUtils.class.getClassLoader().getResource("settings.properties").getFile(),
                    StepUtils.class.getClassLoader().getResource("hidden.properties").getFile(),
                    StepUtils.class.getClassLoader().getResource("features/features.properties").getFile()
            );
        } catch (IOException e) {
            throw new IllegalStateException("cannot load properties", e);
        }
    }

    public static boolean valueOfBooleanFromNotStatus(String notStatus) {

        if (notStatus == null || notStatus.trim().isEmpty()) {
            return true;
        } else if ("not".equalsIgnoreCase(notStatus.trim())) {
            return false;
        }

        throw new IllegalArgumentException(notStatus + ": bad argument format (take only empty or 'not' strings)");
    }
    public static String getProperty(String name) {

        return properties.getProperty(name);
    }

    private static Properties loadProperties(String... fileNames) throws IOException {

        Properties props = new Properties();

        for (String fileName : fileNames) {
            try (InputStream input = new FileInputStream(fileName)) {
                props.load(input);
            }
        }

        return props;
    }
}
