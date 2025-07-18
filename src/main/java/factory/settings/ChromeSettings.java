package factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions settings(String launchParameter) {
        ChromeOptions options = new ChromeOptions();

        switch (launchParameter) {
            case "headless": {
                options.addArguments("--headless");
                return options;
            }
            case "fullscreen": {
                options.addArguments("--fullscreen");
                return options;
            }
            case "incognito": {
                options.addArguments("--incognito");
            }

            default: {
                options.addArguments("--kiosk");
                return options;
            }
        }
    }

}
