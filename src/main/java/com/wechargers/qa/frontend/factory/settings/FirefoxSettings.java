package com.wechargers.qa.frontend.factory.settings;

import com.wechargers.qa.frontend.data.browser.data.EBrowserParameter;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings implements IBrowserSettings {
    @Override
    public AbstractDriverOptions settings(EBrowserParameter parameter) {
        FirefoxOptions options = new FirefoxOptions();

        switch (parameter) {
            case FULLSCREEN -> options.addArguments("--start-maximized");
            case HEADLESS -> options.addArguments("--headless");
            case KIOSK -> options.addArguments("--kiosk");
            case INCOGNITO -> options.addArguments("--private");
        }

        return options;
    }
}