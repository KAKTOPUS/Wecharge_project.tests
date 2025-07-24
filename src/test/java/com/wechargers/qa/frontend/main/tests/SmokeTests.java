package com.wechargers.qa.frontend.main.tests;

import com.wechargers.qa.frontend.utils.EnvUtil;
import com.wechargers.qa.frontend.data.EHomePageData;
import com.wechargers.qa.frontend.main.sut.AbsBaseSut;
import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Smoke тесты")
@Feature("Проверка разделов")
public class SmokeTests extends AbsBaseSut {

    @ParameterizedTest
    @EnumSource(EHomePageData.class)
    public void sectionShouldContainRecords(EHomePageData section) {
        loginPage
                .open(EnvUtil.getEnv("BASE_URL"))
                .enterEmail(EnvUtil.getEnv("EMAIL"))
                .enterPassword(EnvUtil.getEnv("PASSWORD"))
                .clickSubmitButton();

        String sectionName = section.getText();
        homePage.clickOnSection(sectionName);

        assertThat(recordsIsGreaterOrEqual(
                driver,
                pageUtil,
                homePage.getTableRows(),
                1))
                .as("Раздел %s должен содержать записи", sectionName)
                .isTrue();
    }

    @Step("Проверить что в разделе содержится >= {count} записей")
    private static boolean recordsIsGreaterOrEqual(WebDriver driver,
                                                   PageUtil pageUtil,
                                                   List<WebElement> tableElements,
                                                   int count) {
        try {
            List<WebElement> visibleRows = pageUtil.waitForElementsInitialized(driver, tableElements, 10);
            return visibleRows.size() >= count;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
