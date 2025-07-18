package config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverModule extends AbstractModule {

    @Provides
    @Singleton
    public WebDriver providesWebDriver() throws MalformedURLException {
        WebDriverFactory factory = new WebDriverFactory();
        return factory.create(
                System.getProperty("browser"),
                System.getProperty("browser-version"),
                System.getProperty("launch-parameter"),
                System.getProperty("remote-url")
        );
    }
}
