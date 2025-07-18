package pages;

import data.PagesData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbsBasePage {

    private final By emailLocator = By.cssSelector("input[data-v-35b7b272]:not([type='password'])");
    private final By passwordLocator = By.cssSelector("input[type='password']");
    private final By submitButton = By.cssSelector("button[type='submit']");

    @Step("Открыть страницу логина")
    public LoginPage open() {
        super.open(PagesData.LOGIN);
        return this;
    }

    @Step("Ввести email '{email}'")
    public LoginPage enterEmail(String email) {
        WebElement element = pageUtil.waitToInteractWithElement(driver, emailLocator, 10);
        element.clear();
        element.sendKeys(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        WebElement element = pageUtil.waitToInteractWithElement(driver, passwordLocator, 10);
        element.clear();
        element.sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку входа")
    public void clickSubmitButton() {
        WebElement element = pageUtil.waitToInteractWithElement(driver, submitButton, 10);
        element.click();
    }

}