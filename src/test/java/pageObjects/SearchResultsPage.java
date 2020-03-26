package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends PageFather{
    private By popUpCloseButton = By.id("button1");
    private By trainSearchResults = By.id("train_search_results_list");
    private By firstSearchResult = By.xpath("//*[@resource-id='com.thetrainline:id/train_search_results_list']/android.widget.LinearLayout[1]");

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;
    public SearchResultsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webDriverWait = new WebDriverWait(driver,Long.parseLong("10"));
    }
    public SearchResultsPage closePopUp(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(popUpCloseButton));
        driver.findElement(popUpCloseButton).click();
        return this;
    }
    public boolean searchResultIsDisplayed(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(trainSearchResults));
        return driver.findElement(trainSearchResults).isDisplayed();
    }
}
