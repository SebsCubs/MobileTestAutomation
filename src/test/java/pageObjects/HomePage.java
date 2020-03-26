package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageFather{

    private By letsGoButton = By.id("lets_go_button");
    private By allClearButton = By.id("cancel_button");
    private By accountButton = By.id("com.thetrainline:id/action_account");
    private By ticketSearchButton = By.id("action_search");


    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;
    private AccountPage accountPage;
    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver,Long.parseLong("30"));
        accountPage = new AccountPage(driver);
    }

    public HomePage goToSettings(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(letsGoButton));
        driver.findElement(letsGoButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(allClearButton));
        driver.findElement(allClearButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        driver.findElement(accountButton).click();
        accountPage.goToSettingsFromAccount();
        return this;
    }
    public HomePage goToTicketSearch(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(letsGoButton));
        driver.findElement(letsGoButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(allClearButton));
        driver.findElement(allClearButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ticketSearchButton));
        driver.findElement(ticketSearchButton).click();
        return this;
    }

}
