package tests;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.BeforeClass;
import utils.properties.PropertiesLoader;

public class TestBase {
    public static String apiBaseUrl;

    @BeforeClass
    public static void beforeAll() {
        PropertiesLoader.loadSystemProperties();
        PropertiesLoader.loadEnvProperties();

        EnvironmentSpecificConfiguration envConf = EnvironmentSpecificConfiguration.from(
                SystemEnvironmentVariables.createEnvironmentVariables());

        apiBaseUrl = envConf.getProperty("webdriver.base.url") + "api/";
    }
}
