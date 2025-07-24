package com.wechargers.qa.frontend.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PageUtil {

    public WebElement waitToInteractWithElement(WebDriver driver, WebElement element, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(d -> {
                        try {
                            if (element != null && element.isDisplayed() && element.isEnabled()) {
                                return element;
                            }
                            return null;
                        } catch (StaleElementReferenceException e) {
                            return null;
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not intractable after " + timeoutSeconds + " seconds", e);
        }
    }

    public List<WebElement> waitForElementsInitialized(WebDriver driver, List<WebElement> elements, int timeoutSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(d -> {
                        try {
                            return elements != null && !elements.isEmpty() && elements.get(0).isDisplayed()
                                    ? elements
                                    : null;
                        } catch (StaleElementReferenceException e) {
                            return null;
                        }
                    });
        } catch (TimeoutException e) {
            throw new RuntimeException("Elements list not initialized within " + timeoutSeconds + " seconds", e);
        }
    }

}
