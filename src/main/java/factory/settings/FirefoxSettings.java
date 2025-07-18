package factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings {
    public AbstractDriverOptions settings(String launchParameter) {
        FirefoxOptions options = new FirefoxOptions();

        switch (launchParameter) {
            case "headless": {
                options.addArguments("--headless");
                return options;
            }
            case "fullscreen": {
                options.addArguments("--start-maximized");
                return options;
            }
            case "private": {
                options.addArguments("--private");
                return options;
            }
            default: {
                options.addArguments("--kiosk");
                return options;
            }
        }
    }

}