package main.tests;

import data.HomePageData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import listeners.TestFailureListener;
import main.sut.AbsBaseSut;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Smoke тесты")
@Feature("Проверка разделов")
@ExtendWith(TestFailureListener.class)
public class Smoke_Tests extends AbsBaseSut {

    @ParameterizedTest
    @EnumSource(HomePageData.class)
    public void section_should_contain_records(HomePageData section) {
        loginPage.open()
                .enterEmail(dataPropertiesUtil.getEmailFromProperties())
                .enterPassword(dataPropertiesUtil.getPasswordFromProperties())
                .clickSubmitButton();

        String sectionName = section.getText();
        homePage.clickOnSection(sectionName);
        assertThat(tableValidatorUtil.hasRecords(homePage.getTableRowLocator()))
                .as("Раздел %s должен содержать записи", sectionName)
                .isTrue();
    }

}
