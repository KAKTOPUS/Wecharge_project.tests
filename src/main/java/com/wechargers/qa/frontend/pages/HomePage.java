package com.wechargers.qa.frontend.pages;

import com.google.inject.Inject;
import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends AbsBasePage<HomePage> {

    @FindBy(css = "a[href^='/']")
    private List<WebElement> allSectionsLinks;
    @FindBy(css = "tr[class*='el-table__row']")
    private List<WebElement> tableRowLocator;

    @Inject
    public HomePage(WebDriver driver, PageUtil pageUtil) {
        super(driver, pageUtil);
    }

    @Step("Кликнуть на раздел '{sectionName}'")
    public void clickOnSection(String sectionName) {
        allSectionsLinks
                       .stream()
                       .filter(el -> el.getAttribute("href").endsWith("/" + sectionName))
                       .findFirst()
                       .ifPresent(WebElement::click);
    }

    @Step("Получить строки таблицы")
    public List<WebElement> getTableRows() {
        return tableRowLocator;
    }

}
