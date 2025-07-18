package main.sut;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import config.GuiceModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utils.DataPropertiesUtil;
import utils.TableValidatorUtil;

public abstract class AbsBaseSut {
    @Inject
    protected WebDriver driver;
    @Inject
    protected HomePage homePage;
    @Inject
    protected LoginPage loginPage;
    @Inject
    protected DataPropertiesUtil dataPropertiesUtil;
    @Inject
    protected TableValidatorUtil tableValidatorUtil;


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