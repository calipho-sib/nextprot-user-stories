package org.nextprot;


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
                    StepUtils.class.getClassLoader().getResource("hidden.properties").getFile()
            );
        } catch (IOException e) {
            throw new IllegalStateException("cannot load properties", e);
        }
    }

    public static boolean valueOfShouldBeStatus(String shouldStatus) {

        boolean shouldBe;

        if ("should".equalsIgnoreCase(shouldStatus)) {
            shouldBe = true;
        } else if ("should not".equalsIgnoreCase(shouldStatus)) {
            shouldBe = false;
        } else {
            throw new IllegalArgumentException(shouldStatus + ": bad argument format (take only values 'should' or 'should not')");
        }

        return shouldBe;
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
