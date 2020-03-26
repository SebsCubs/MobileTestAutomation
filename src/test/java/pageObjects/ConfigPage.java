package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfigPage extends PageFather {
    private By currencyText = By.id("selected_currency_text");
    private By notificationsCheckBoxStatus = By.id("help_item_checkbox");
    private By notificationsCheckBox = By.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout[1]");
    private By selectCurrencyButton = By.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout[2]");
    private By contactFAQsButton = By.xpath("//*[@resource-id='android:id/list']/android.widget.RelativeLayout[8]");
    private By EURSelector = By.xpath("//*[@resource-id='com.thetrainline:id/currency_switcher_container']/android.widget.LinearLayout[4]");


    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;
    public ConfigPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver,Long.parseLong("30"));
    }

    public ConfigPage setCurrencyToEUR(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currencyText));
        driver.findElement(selectCurrencyButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(EURSelector));
        driver.findElement(EURSelector).click();
        return this;
    }
    public ConfigPage turnOffNotifications(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(notificationsCheckBox));
        driver.findElement(notificationsCheckBox).click();
        return this;
    }
    public ConfigPage openFAQsActivity(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(contactFAQsButton));
        driver.findElement(contactFAQsButton).click();
        return this;
    }
    public String getNotCheckBoxStatus(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(notificationsCheckBoxStatus));
        return driver.findElement(notificationsCheckBoxStatus).getAttribute("checked");
    }
    public String getCurrentCurrency(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currencyText));
        return driver.findElement(currencyText).getText();
    }
}
