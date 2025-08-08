package com.wechargers.qa.frontend.factory.settings;

import com.wechargers.qa.frontend.data.browser.data.EBrowserParameter;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions settings(EBrowserParameter parameter) {
        ChromeOptions options = new ChromeOptions();

        switch (parameter) {
            case FULLSCREEN -> options.addArguments("--start-maximized");
            case HEADLESS -> options.addArguments("--headless");
            case KIOSK -> options.addArguments("--kiosk");
            case INCOGNITO -> options.addArguments("--incognito");
        }

        return options;
    }

}