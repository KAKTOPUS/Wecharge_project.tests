package com.wechargers.qa.frontend.factory.settings;

import com.wechargers.qa.frontend.data.browser.data.EBrowserParameter;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface IBrowserSettings {
    AbstractDriverOptions settings(EBrowserParameter launchParameter);
}

