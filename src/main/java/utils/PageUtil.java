package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageUtil {

    public WebElement waitToInteractWithElement(WebDriver driver, By locator, int timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public WebElement waitForElementPresence(WebDriver driver, By locator, int timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    public List<WebElement> waitForElements(WebDriver driver, By locator, int timeOutSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

}
