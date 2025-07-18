package listeners;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import utils.AllureHelperUtil;

import java.lang.reflect.Field;

public class TestFailureListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            Object testInstance = context.getRequiredTestInstance();
            Field driverField = testInstance.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            WebDriver driver = (WebDriver) driverField.get(testInstance);

            AllureHelperUtil.takeScreenshot(driver, "FAILED: " + context.getDisplayName());
            Allure.addDescription("Test failed reason: " + cause.getMessage());

        } catch (Exception e) {
            Allure.addAttachment("Error", "Failed to capture screenshot: " + e.getMessage());
        }
    }

}