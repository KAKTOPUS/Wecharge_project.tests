package com.wechargers.qa.frontend.pages.main.pages;

import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class AbsBasePage<T extends AbsBasePage<T>> {
    protected final WebDriver driver;
    protected final PageUtil pageUtil;

    public AbsBasePage(WebDriver driver, PageUtil pageUtil) {
        this.driver = driver;
        this.pageUtil = pageUtil;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @Step("Открыть страницу {baseUrl}")
    public T open(String baseUrl) {
        driver.get(baseUrl);
        return (T) this;
    }

}