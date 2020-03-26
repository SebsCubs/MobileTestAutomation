package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import pageObjects.SearchResultsPage;

public class SearchResultsPageSteps {
    private SearchResultsPage searchResultsPage;
    private AppiumDriver driver;
    public SearchResultsPageSteps(Hooks hooks){
        driver = hooks.getWebDriver();
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Then("a new screen with ticket results sorted by price is shown")
    public void aNewScreenWithTicketResultsSortedByPriceIsShown() {
        MatcherAssert.assertThat("Error: couldn't find the search results",
                searchResultsPage.searchResultIsDisplayed(), CoreMatchers.equalTo(true));
    }
}
