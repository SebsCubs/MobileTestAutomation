package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FAQsPage extends PageFather {
    private By refundsButton = By.xpath("//*[@resource-id='com.thetrainline:id/webview_screen']/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.ListView[1]/android.view.View[1]/android.view.View");
    private By mainlandButton = By.xpath("//*[@resource-id='com.thetrainline:id/webview_screen']/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View/android.widget.ListView[2]/android.view.View[2]/android.view.View");
    private By mainLandTittle = By.xpath("//*[@resource-id='com.thetrainline:id/webview_screen']//android.view.View[contains(@text,'Travel in mainland Europe')]");
    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;

    public FAQsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Long.parseLong("10"));
    }

    public FAQsPage openRefundsSection() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(refundsButton));
        driver.findElement(refundsButton).click();
        return this;
    }

    public FAQsPage openMainlandFAQs() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(mainlandButton));
        driver.findElement(mainlandButton).click();
        return this;
    }

    public String getFaqTittle() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(mainLandTittle));
        return driver.findElement(mainLandTittle).getText();
    }


}
