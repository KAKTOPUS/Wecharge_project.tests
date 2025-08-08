package com.wechargers.qa.frontend.factory;

import com.wechargers.qa.frontend.data.browser.data.EBrowserParameter;
import com.wechargers.qa.frontend.data.browser.data.EBrowserType;
import com.wechargers.qa.frontend.factory.settings.ChromeSettings;
import com.wechargers.qa.frontend.factory.settings.FirefoxSettings;
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
    public WebDriver create(EBrowserType browser, String browserVersion, EBrowserParameter parameter, String remoteUrl) {
         // Удаленный запуск
         if (remoteUrl != null && !remoteUrl.isBlank()) {
             try {
                 URL url = new URL(remoteUrl);
                 MutableCapabilities capabilities = new MutableCapabilities();
                 capabilities.setCapability("browserName", browser.toString().toLowerCase());

                 if (browserVersion != null && !browserVersion.isBlank()) {
                     capabilities.setCapability("browserVersion", browserVersion);
                 }

                 return new RemoteWebDriver(url, capabilities);
             } catch (MalformedURLException e) {
                 throw new RuntimeException("Invalid grid URL: " + remoteUrl, e);
             }
         }
         // Локальный запуск
         return switch (browser) {
             case CHROME -> new ChromeDriver((ChromeOptions) new ChromeSettings().settings(parameter));
             case FIREFOX -> new FirefoxDriver((FirefoxOptions) new FirefoxSettings().settings(parameter));
         };

    }

}