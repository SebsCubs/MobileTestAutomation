package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TicketSearchPage extends HomePage {
    private By GPSaccessPermission = By.id("com.android.packageinstaller:id/permission_allow_button");
    private By destinationButton = By.id("btn_to");
    private By originButton = By.id("btn_from");
    private By stationSearch = By.id("com.thetrainline:id/search_station_searchbox");
    private By secondSearchResult = By.xpath("//*[@resource-id='com.thetrainline:id/search_result_list']/android.view.ViewGroup[2]");
    private By searchJourneyButton = By.id("search_journey_btn");

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait webDriverWait;
    private SearchResultsPage searchResultsPage;

    public TicketSearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        this.driver = driver;
        searchResultsPage = new SearchResultsPage(driver);
        webDriverWait = new WebDriverWait(driver, Long.parseLong("30"));
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
    }

    public TicketSearchPage journeySearch(String origin, String destination) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(originButton));
        driver.findElement(originButton).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(stationSearch));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(stationSearch));
        driver.findElement(stationSearch).click();
        driver.findElement(stationSearch).sendKeys(origin);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(secondSearchResult));
        driver.findElement(secondSearchResult).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(destinationButton));
        driver.findElement(destinationButton).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(stationSearch));
        driver.findElement(stationSearch).click();
        driver.findElement(stationSearch).sendKeys(destination);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(secondSearchResult));
        driver.findElement(secondSearchResult).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(searchJourneyButton));
        driver.findElement(searchJourneyButton).click();
        searchResultsPage.closePopUp();
        return this;
    }


}
