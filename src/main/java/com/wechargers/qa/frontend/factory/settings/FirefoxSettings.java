package com.wechargers.qa.frontend.factory.settings;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class FirefoxSettings {
    public AbstractDriverOptions settings(String launchParameter) {
        FirefoxOptions options = new FirefoxOptions();

        // Обязательные параметры для всех режимов
        options.addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-infobars",
                "--disable-extensions",
                "--disable-notifications",
                "--language=en"
        );

        try {
            if (launchParameter != null && !launchParameter.isEmpty()) {
                switch (launchParameter.toLowerCase()) {
                    case "headless":
                        options.addArguments("--headless");
                        break;
                    case "fullscreen":
                        options.addArguments("--start-maximized");
                        break;
                    case "private":
                        options.addArguments("--private");
                        break;
                    case "kiosk":
                        options.addArguments("--kiosk");
                        break;
                    default:
                        // Оставляем только базовые настройки
                }
            }
        } catch (Exception e) {
            return new FirefoxOptions()
                    .addArguments("--no-sandbox", "--disable-dev-shm-usage");
        }

        return options;
    }
}