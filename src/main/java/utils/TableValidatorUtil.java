package utils;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableValidatorUtil {
    private final PageUtil pageUtil;
    private final WebDriver driver;

    @Inject
    public TableValidatorUtil(WebDriver driver, PageUtil pageUtil) {
        this.driver = driver;
        this.pageUtil = pageUtil;
    }

    @Step("Проверить наличие записей в таблице")
    public boolean hasRecords(By tableLocator) {
        List<WebElement> rows = pageUtil.waitForElements(driver, tableLocator, 10);
        return !rows.isEmpty();
    }
}
