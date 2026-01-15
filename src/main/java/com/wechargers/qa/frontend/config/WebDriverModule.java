package com.wechargers.qa.frontend.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.wechargers.qa.frontend.data.browser.data.EBrowserParameter;
import com.wechargers.qa.frontend.utils.EnvUtil;
import com.wechargers.qa.frontend.data.browser.data.EBrowserType;
import com.wechargers.qa.frontend.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverModule extends AbstractModule {

    @Provides
    @Singleton
    public WebDriver providesWebDriver() {
        WebDriverFactory factory = new WebDriverFactory();
        return factory.create(
                EBrowserType.FIREFOX,
                EnvUtil.getEnv("BROWSER_VERSION"),
                EBrowserParameter.FULLSCREEN,
                EnvUtil.getEnv("REMOTE_URL")
        );
    }

    @Provides
    public Actions provideActions(WebDriver driver) {
        return new Actions(driver);
    }

}
