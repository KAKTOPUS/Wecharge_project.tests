package factory;

import factory.settings.ChromeSettings;
import factory.settings.FirefoxSettings;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public WebDriver create(String browser, String browserVersion, String launchParameter, String remoteUrl) throws MalformedURLException {

        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty");
        }

        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("browserVersion", browserVersion);

            return new RemoteWebDriver(new URL(remoteUrl), capabilities);
        }

        switch (browser) {
            case "chrome": {
                return new ChromeDriver((ChromeOptions) new ChromeSettings().settings(launchParameter));
            }
            case "firefox": {
                return new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings(launchParameter));
            }
        }

        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
}