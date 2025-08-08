package com.wechargers.qa.frontend.main.sut;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.wechargers.qa.frontend.config.GuiceModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import com.wechargers.qa.frontend.pages.HomePage;
import com.wechargers.qa.frontend.pages.LoginPage;

public abstract class AbsBaseSut {
    @Inject
    protected WebDriver driver;
    @Inject
    protected HomePage homePage;
    @Inject
    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        Injector injector = Guice.createInjector(new GuiceModule());
        injector.injectMembers(this);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}