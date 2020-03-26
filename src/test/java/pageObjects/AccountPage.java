package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends PageFather {

    private By settingsButton = By.id("com.thetrainline:id/settings_button");

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;

    public AccountPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Long.parseLong("30"));
    }

    public AccountPage goToSettingsFromAccount() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(settingsButton));
        driver.findElement(settingsButton).click();
        return this;
    }
}
