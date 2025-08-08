package com.wechargers.qa.frontend.pages;

import com.google.inject.Inject;
import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbsBasePage<LoginPage> {

    @FindBy(css = "input[data-v-35b7b272]:not([type='password'])")
    private WebElement emailLocator;
    @FindBy(css = "input[type='password']")
    private WebElement passwordLocator;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButtonLocator;
    private final Actions actions;

    @Inject
    public LoginPage(WebDriver driver, PageUtil pageUtil, Actions actions) {
        super(driver, pageUtil);
        this.actions = actions;
    }

    @Step("Ввести email '{email}'")
    public LoginPage enterEmail(String email) {
        pageUtil.waitForElementToBeClickable(driver, emailLocator, 10);
        actions
                .click(emailLocator)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();
        emailLocator.sendKeys(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        pageUtil.waitForElementToBeClickable(driver, passwordLocator, 10);
        actions
                .click(passwordLocator)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();
        passwordLocator.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public void clickSubmitButton() {
        pageUtil
                .waitForElementToBeClickable(driver, submitButtonLocator, 10)
                .click();
    }

}