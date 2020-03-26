package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.When;
import pageObjects.TicketSearchPage;

public class TicketSearchPageSteps {
    private TicketSearchPage ticketSearchPage;
    private AppiumDriver driver;
    public TicketSearchPageSteps(Hooks hooks){
        driver = hooks.getWebDriver();
        ticketSearchPage = new TicketSearchPage(driver);
    }

    @When("a search for a train ticket from {string} to {string} is made")
    public void aSearchForATrainTicketFromToIsMade(String origin, String destination) {
        ticketSearchPage.journeySearch(origin,destination);
    }
}
