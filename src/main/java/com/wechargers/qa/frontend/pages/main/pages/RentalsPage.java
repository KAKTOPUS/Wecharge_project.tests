package com.wechargers.qa.frontend.pages.main.pages;

import com.google.inject.Inject;
import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalsPage extends AbsBasePage<RentalsPage> {

    @FindBy(css = "div[class='link-container']")
    private List<WebElement> rentsLinks;
    @FindBy(css = "div[class='url-title']")
    private List<WebElement> rentsID;
    @FindBy(css = "section[class^='status']")
    private List<WebElement> rentsStatus;
    @FindBy(css = "td[class*='column_3']>.cell")
    private List<WebElement> rentsDate;
    @FindBy(css = "td[class*='column_4']>.cell")
    private List<WebElement> rentsStartVenueID;
    @FindBy(css = "td[class*='column_5']>.cell")
    private List<WebElement> rentsStationNumber;
    @FindBy(css = "td[class*='column_6']>.cell")
    private List<WebElement> rentsReturnDate;
    @FindBy(css = "td[class*='column_7']>.cell")
    private List<WebElement> rentsReturnVenueID;
    @FindBy(css = "td[class*='column_8']>.cell")
    private List<WebElement> rentsReturnStationNumber;
    @FindBy(css = "td[class*='column_10']>.cell")
    private List<WebElement> rentsUserPhoneMail;
    @FindBy(css = "td[class*='column_11']>.cell")
    private List<WebElement> rentsSerialNumber;

    @Inject
    public RentalsPage(WebDriver driver, PageUtil pageUtil) {
        super(driver, pageUtil);
    }

    @Step("Открыть запись первой записи Rentals")
    public void openFirstRentLink() {
        pageUtil.waitForElementToBeClickable(driver, rentsLinks.get(0), 10).click();
    }

    @Step("Получить Rent ID первой записи Rentals")
    public String getFirstRentID() {
        return pageUtil.waitForElementIsVisible(driver, rentsID.get(0), 10).getText();
    }

    @Step("Получить Status первой записи Rentals")
    public String getFirstRentStatus() {
        return pageUtil.waitForElementIsVisible(driver, rentsStatus.get(0), 10).getText();
    }

    @Step("Получить Start Date первой записи Rentals")
    public String getFirstRentStartDate() {
        String date = pageUtil.waitForElementIsVisible(driver, rentsDate.get(0), 10).getText();
        return pageUtil.convertDateToDetailForm(date);
    }

    @Step("Получить Start Venue ID первой записи Rentals")
    public String getFirstRentStartVenueID() {
        return pageUtil.waitForElementIsVisible(driver, rentsStartVenueID.get(0), 10).getText();
    }

    @Step("Получить Start Station Number первой записи Rentals")
    public String getFirstRentStationNumber() {
        return pageUtil.waitForElementIsVisible(driver, rentsStationNumber.get(0), 10).getText();
    }

    @Step("Получить Return Date первой записи Rentals")
    public String getFirstRentReturnDate() {
        String returnDate = pageUtil.waitForElementIsVisible(driver, rentsReturnDate.get(0), 10).getText();
        return pageUtil.convertDateToDetailForm(returnDate);

    }

    @Step("Получить Return Venue ID первой записи Rentals")
    public String getFirstRentReturnVenueID() {
        String date = pageUtil.waitForElementIsVisible(driver, rentsReturnVenueID.get(0), 10).getText();
        return pageUtil.convertDateToDetailForm(date);
    }

    @Step("Получить Return Station Number первой записи Rentals")
    public String getFirstRentReturnStationNumber() {
        return pageUtil.waitForElementIsVisible(driver, rentsReturnStationNumber.get(0), 10).getText();
    }

    @Step("Получить Mail/Phone первой записи Rentals")
    public String getFirstRentUserMailPhone() {
        return pageUtil.waitForElementIsVisible(driver, rentsUserPhoneMail.get(0), 10).getText();
    }

    @Step("Получить Serial Number первой записи Rentals")
    public String getFirstRentSerialNumber() {
        return pageUtil.waitForElementIsVisible(driver, rentsSerialNumber.get(0), 10).getText();
    }

    @Step("Собрать информацию первой записи Rentals")
    public Map<String, String> getDataFromFirstRecordRentals() {
        Map<String, String> map = new HashMap<>();
        map.put("rentID", getFirstRentID());
        map.put("status", getFirstRentStatus());
        map.put("startDate", getFirstRentStartDate());
        map.put("startVenueID", getFirstRentStartVenueID());
        map.put("stationNumber", getFirstRentStationNumber());
        map.put("returnDate", getFirstRentReturnDate());
        map.put("returnVenueID", getFirstRentReturnVenueID());
        map.put("returnStationNumber", getFirstRentReturnStationNumber());
        map.put("mailPhone", getFirstRentUserMailPhone());
        map.put("serialNumber", getFirstRentSerialNumber());

        return map;
    }

}
