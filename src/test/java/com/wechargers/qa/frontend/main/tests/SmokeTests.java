package com.wechargers.qa.frontend.main.tests;

import com.wechargers.qa.frontend.utils.EnvUtil;
import com.wechargers.qa.frontend.data.pages.data.EHomePageData;
import com.wechargers.qa.frontend.main.sut.AbsBaseSut;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Smoke тесты")
public class SmokeTests extends AbsBaseSut {
    @BeforeEach
    public void login() {
        loginPage
                .open(EnvUtil.getEnv("BASE_URL"))
                .enterEmail(EnvUtil.getEnv("EMAIL"))
                .enterPassword(EnvUtil.getEnv("PASSWORD"))
                .clickSubmitButton();
    }
    @ParameterizedTest()
    @EnumSource(EHomePageData.class)
    public void tableOfSectionShouldContainRecords(EHomePageData section) {
        homePage.clickOnSection(section.toString().toLowerCase());

        assertThat(checkTableHasRecords(homePage.getTableRows(), 10))
                .as("Раздел %s должен содержать записи", section.toString().toLowerCase())
                .isTrue();
    }

    @Test
    public void compareDataFromRentalsPageWithDetailPage() {
        homePage.clickOnSection(EHomePageData.RENTS.toString().toLowerCase());
        Map<String, String> rentalsPageData = rentalsPage.getDataFromFirstRecordRentals();
        rentalsPage.openFirstRentLink();
        Map<String, String> rentalsDetailPageData = rentalsDetailPage.getDataFromDetailRentals();
        compareData(rentalsPageData, rentalsDetailPageData);
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

    @Step("Сравниваем данные главной страницы с детальной")
    private static void compareData(Map<String, String> actualMap, Map<String, String> expectedMap) {
        expectedMap.forEach((key, expectedValue) -> {
            assertThat(actualMap)
                    .as("Проверка ключа '%s'", key)
                    .containsKey(key);

            assertThat(expectedValue.trim().toLowerCase())
                    .as("Проверка значения для ключа '%s'", key)
                    .contains(actualMap.get(key).trim().toLowerCase());
        });
    }

}
