package com.wechargers.qa.frontend.factory.settings;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeSettings implements IBrowserSettings {

    @Override
    public AbstractDriverOptions settings(String launchParameter) {
        ChromeOptions options = new ChromeOptions();

        // Обязательные параметры для всех режимов
        options.addArguments(
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "--disable-infobars",
                "--disable-extensions",
                "--disable-notifications",
                "--lang=en-US"
        );

        try {
            if (launchParameter != null && !launchParameter.isEmpty()) {
                switch (launchParameter.toLowerCase()) {
                    case "headless":
                        options.addArguments("--headless", "--disable-gpu");
                        break;
                    case "fullscreen":
                        options.addArguments("--start-maximized");
                        break;
                    case "incognito":
                        options.addArguments("--incognito");
                        break;
                    case "kiosk":
                        options.addArguments("--kiosk");
                        break;
                    default:
                        // Оставляем только базовые настройки
                }
            }
        } catch (Exception e) {
            return new ChromeOptions()
                    .addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        }

        return options;
    }

}