package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import pageObjects.HomePage;

public class HomePageSteps {
    private HomePage homePage;

    public HomePageSteps(Hooks hooks){
        AppiumDriver<MobileElement> driver = hooks.getWebDriver();
        homePage = new HomePage(driver);
    }

    @Given("the trainline app is opened in the settings screen")
    public void theTrainlineAppIsOpenedInTheSettingsScreen() {
        homePage.goToSettings();
    }

    @Given("the search screen is opened")
    public void theSearchScreenIsOpened() {
        homePage.goToTicketSearch();
    }
}
