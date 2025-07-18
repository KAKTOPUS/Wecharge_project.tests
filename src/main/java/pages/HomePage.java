package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends AbsBasePage {

    private static final String FLEX_CONTAINER_LOCATOR = "a[href='/%s']";
    private final By tableRowLocator = By.cssSelector("tr[class*='el-table__row']");

    @Step("Кликнуть на раздел '{sectionName}'")
    public void clickOnSection(String sectionName) {
        By locator = By.cssSelector(String.format(FLEX_CONTAINER_LOCATOR, sectionName));
        WebElement element = pageUtil.waitForElementPresence(driver, locator, 10);
        element.click();
    }

    @Step("Получить локатор строк таблицы")
    public By getTableRowLocator() {
        return tableRowLocator;
    }

}
