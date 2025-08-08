package com.wechargers.qa.frontend.main.tests;

import com.wechargers.qa.frontend.utils.EnvUtil;
import com.wechargers.qa.frontend.data.pages.data.EHomePageData;
import com.wechargers.qa.frontend.main.sut.AbsBaseSut;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Smoke тесты")
@Feature("Проверка разделов")
public class SmokeTests extends AbsBaseSut {

    @ParameterizedTest()
    @EnumSource(EHomePageData.class)
    public void tableOfSectionShouldContainRecords(EHomePageData section) {
        loginPage
                .open(EnvUtil.getEnv("BASE_URL"))
                .enterEmail(EnvUtil.getEnv("EMAIL"))
                .enterPassword(EnvUtil.getEnv("PASSWORD"))
                .clickSubmitButton();

        homePage.clickOnSection(section.toString().toLowerCase());

        assertThat(checkTableHasRecords(homePage.getTableRows(), 10))
                .as("Раздел %s должен содержать записи", section.toString().toLowerCase())
                .isTrue();
    }

    @Step("Проверить что в таблице содержится >= {count} записей")
    private static boolean checkTableHasRecords(List<WebElement> rows, int count) {
        return rows
                       .parallelStream()
                       .allMatch(element ->
                           element != null &&
                           element.isDisplayed() &&
                           !element.getText().isBlank()
                       ) &&
                       rows.size() >= count;
    }

}
