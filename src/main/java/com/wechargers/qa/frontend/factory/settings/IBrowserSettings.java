package com.wechargers.qa.frontend.factory.settings;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSettings {
    AbstractDriverOptions settings(String launchParameter);
}

