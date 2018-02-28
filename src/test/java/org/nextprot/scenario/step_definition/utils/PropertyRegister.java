package org.nextprot.scenario.step_definition.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyRegister {

    private static final Properties properties;

    private PropertyRegister() {
        throw new IllegalAccessError("not instanciable");
    }

    static {
        try {
            properties = loadProperties(
                    PropertyRegister.class.getClassLoader().getResource("settings.properties").getFile(),
                    PropertyRegister.class.getClassLoader().getResource("hidden.properties").getFile(),
                    PropertyRegister.class.getClassLoader().getResource("features/features.properties").getFile()
            );

        } catch (IOException e) {
            throw new IllegalStateException("cannot load properties", e);
        }
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

        String propertyThatCanBeOverriden = "webdriver.remote.url";
        if(System.getProperty(propertyThatCanBeOverriden) != null) {
            System.err.println("Overriding webdriver.remote.url with: " + System.getProperty(propertyThatCanBeOverriden));
            props.put(propertyThatCanBeOverriden, System.getProperty(propertyThatCanBeOverriden));
        }

        return props;
    }
}
