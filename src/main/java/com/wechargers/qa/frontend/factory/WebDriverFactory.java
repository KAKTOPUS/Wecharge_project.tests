package com.wechargers.qa.frontend.factory;

import com.wechargers.qa.frontend.factory.settings.ChromeSettings;
import com.wechargers.qa.frontend.factory.settings.FirefoxSettings;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    public WebDriver create(String browser, String browserVersion, String launchParameter, String remoteUrl) {
        try {
            // Валидация входных параметров
            if (browser == null || browser.trim().isEmpty()) {
                throw new IllegalArgumentException("Browser name must be specified");
            }

            // Удаленный запуск
            if (remoteUrl != null && !remoteUrl.trim().isEmpty()) {
                try {
                    URL url = new URL(remoteUrl);
                    MutableCapabilities capabilities = new MutableCapabilities();
                    capabilities.setCapability("browserName", browser.toLowerCase());

                    if (browserVersion != null && !browserVersion.trim().isEmpty()) {
                        capabilities.setCapability("browserVersion", browserVersion);
                    }

                    return new RemoteWebDriver(url, capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Invalid grid URL: " + remoteUrl, e);
                }
            }

            // Локальный запуск
            try {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        return new ChromeDriver((ChromeOptions) new ChromeSettings()
                                .settings(launchParameter));
                    case "firefox":
                        return new FirefoxDriver((FirefoxOptions) new FirefoxSettings()
                                .settings(launchParameter));
                    default:
                        throw new IllegalArgumentException(
                                "Unsupported browser: " + browser + ". Supported: chrome, firefox");
                }
            } catch (WebDriverException e) {
                throw new RuntimeException("Failed to initialize local " + browser + " driver", e);
            }

        } catch (Exception e) {
            throw new RuntimeException("WebDriver initialization failed: " + e.getMessage(), e);
        }
    }

}