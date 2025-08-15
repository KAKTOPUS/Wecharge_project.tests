package com.wechargers.qa.frontend.pages.detail.pages;

import com.google.inject.Inject;
import com.wechargers.qa.frontend.pages.main.pages.AbsBasePage;
import com.wechargers.qa.frontend.utils.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;

public class RentalsDetailPage extends AbsBasePage<RentalsDetailPage> {
    @FindBy(css = "div[class='subtitle']")
    private WebElement detailStatus;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Rent ID')]]")
    private WebElement detailRentID;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Start Date')]]")
    private WebElement detailStartDate;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Start Venue ID')]]")
    private WebElement detailStartVenueID;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Serial number')]]")
    private WebElement detailSerialNumber;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'User Phone N/Email')]]")
    private WebElement detailMailNumber;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Start Station Number')]]")
    private WebElement detailStartStationNumber;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Return Venue ID')]]")
    private WebElement detailReturnVenueID;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Return Date')]]")
    private WebElement detailReturnDate;
    @FindBy(xpath = "//div[@class='info-block__row'][.//div[contains(text(), 'Return Station Number')]]")
    private WebElement detailReturnStationNumber;

    @Inject
    public RentalsDetailPage(WebDriver driver, PageUtil pageUtil) {
        super(driver, pageUtil);
    }

    @Step("Получить Status детальной страницы Rentals")
    public String getDetailRentStatus() {
        return pageUtil.waitForElementToBeClickable(driver, detailStatus, 10).getText();
    }

    @Step("Получить Rent ID детальной страницы Rentals")
    public String getDetailRentID() {
        return pageUtil.waitForElementIsVisible(driver, detailRentID, 10).getText();
    }

    @Step("Получить Start Date детальной страницы Rentals")
    public String getDetailRentStartDate() {
        return pageUtil.waitForElementIsVisible(driver, detailStartDate, 10).getText();
    }

    @Step("Получить Start Venue ID детальной страницы Rentals")
    public String getDetailRentStartVenueID() {
        return pageUtil.waitForElementIsVisible(driver, detailStartVenueID, 10).getText();
    }

    @Step("Получить Serial Number детальной страницы Rentals")
    public String getDetailRentSerialNumber() {
        return pageUtil.waitForElementIsVisible(driver, detailSerialNumber, 10).getText();
    }

    @Step("Получить Mail/Phone детальной страницы Rentals")
    public String getDetailRentMailPhone() {
        return pageUtil.waitForElementIsVisible(driver, detailMailNumber, 10).getText();
    }

    @Step("Получить Start Station Number детальной страницы Rentals")
    public String getDetailRentStartStationNumber() {
        return pageUtil.waitForElementIsVisible(driver, detailStartStationNumber, 10).getText();
    }

    @Step("Получить Return Venue ID детальной страницы Rentals")
    public String getDetailRentReturnVenueID() {
        return pageUtil.waitForElementIsVisible(driver, detailReturnVenueID, 10).getText();
    }

    @Step("Получить Return Date детальной страницы Rentals")
    public String getDetailRentReturnDate() {
        return pageUtil.waitForElementIsVisible(driver, detailReturnDate, 10).getText();
    }

    @Step("Получить Return Station Number детальной страницы Rentals")
    public String getDetailRentReturnStationNumber() {
        return pageUtil.waitForElementIsVisible(driver, detailReturnStationNumber, 10).getText();
    }

    @Step("Собрать информацию детальной страницы Rentals")
    public Map<String, String> getDataFromDetailRentals() {
        Map<String, String> map = new HashMap<>();
        map.put("rentID", getDetailRentID());
        map.put("status", getDetailRentStatus());
        map.put("startDate", getDetailRentStartDate());
        map.put("startVenueID", getDetailRentStartVenueID());
        map.put("stationNumber", getDetailRentStartStationNumber());
        map.put("returnDate", getDetailRentReturnDate());
        map.put("returnVenueID", getDetailRentReturnVenueID());
        map.put("returnStationNumber", getDetailRentReturnStationNumber());
        map.put("mailPhone", getDetailRentMailPhone());
        map.put("serialNumber", getDetailRentSerialNumber());

        return map;
    }

}
