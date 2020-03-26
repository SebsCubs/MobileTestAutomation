package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import pageObjects.ConfigPage;

public class ConfigPageSteps {
    private ConfigPage configPage;
    private AppiumDriver driver;
    public ConfigPageSteps(Hooks hooks){
        driver = hooks.getWebDriver();
        configPage = new ConfigPage(driver);
    }

    @Given("the current currency is {string}")
    public void theCurrentCurrencyIs(String currentCurrency) {
        String actualCurrency = configPage.getCurrentCurrency();
        MatcherAssert.assertThat("Error: the current currency is not"+currentCurrency,
                actualCurrency.contains(currentCurrency), CoreMatchers.equalTo(true));
    }

    @When("the currency is changed to EUR")
    public void theCurrencyIsChangedToEUR() {
        configPage.setCurrencyToEUR();
    }

    @Then("search results show prices in the new currency")
    public void searchResultsShowPricesInTheNewCurrency() {
        String actualCurrency = configPage.getCurrentCurrency();
        MatcherAssert.assertThat("Error: the current didn't change to EUR",
                actualCurrency.contains("EUR"), CoreMatchers.equalTo(true));
    }


    @Given("the push notifications are enabled")
    public void thePushNotificationsAreEnabled() {
        MatcherAssert.assertThat("Error: notifications are already off",
                configPage.getNotCheckBoxStatus(), CoreMatchers.equalTo("true"));
    }

    @When("the notifications are turned off")
    public void theNotificationsAreTurnedOff() {
        configPage.turnOffNotifications();
    }

    @Then("the app won't generate push notifications")
    public void theAppWonTGeneratePushNotifications() {
        MatcherAssert.assertThat("Error: notifications are not off",
                configPage.getNotCheckBoxStatus(), CoreMatchers.equalTo("false"));
    }

    @Given("the contactFAQs screen is opened")
    public void theContactFAQsScreenIsOpened() {
        configPage.openFAQsActivity();
    }

}
