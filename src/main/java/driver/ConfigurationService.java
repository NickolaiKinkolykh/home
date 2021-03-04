package driver;

import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;

public class ConfigurationService {

    private static Configuration CONFIGURATION = null;
    private static String PATH_TO_PROPERTIES = "src/test/resources/properties/browser.properties";

    public static Configuration getConfInstance(){
        try {
            CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
            compositeConfiguration.addConfiguration(new SystemConfiguration());
            PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
            propertiesConfiguration.read(new PropertiesConfiguration.PropertiesReader(new FileReader(PATH_TO_PROPERTIES)));
            compositeConfiguration.addConfiguration(propertiesConfiguration);
            CONFIGURATION = compositeConfiguration;
        } catch (ConfigurationException | IOException e) {
            throw new IllegalStateException("Unable to load configuration", e);
        }
        return CONFIGURATION;
    }

    public static String getTestProperty(String property, String defaultValue) {
        return getConfInstance().getString(property, defaultValue).trim();
    }

    public static String getTestProperty(String property) {
        return getTestProperty(property, StringUtils.EMPTY);
    }

}
