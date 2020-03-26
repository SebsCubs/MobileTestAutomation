package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import pageObjects.FAQsPage;

public class FAQsPageSteps {
    private FAQsPage faQsPage;
    private AppiumDriver driver;
    public FAQsPageSteps(Hooks hooks){
        driver = hooks.getWebDriver();
        faQsPage = new FAQsPage(driver);
    }

    @When("the Ticket refunds and changes section is selected")
    public void theTicketRefundsAndChangesSectionIsSelected() {
        faQsPage.openRefundsSection();
    }

    @And("the Travel in mainland Europe tag is selected")
    public void theTravelInMainlandEuropeTagIsSelected() {
        faQsPage.openMainlandFAQs();
    }

    @Then("the eight FAQs for Europe mainland ticket conditions are shown")
    public void theEightFAQsForEuropeMainlandTicketConditionsAreShown() {
        MatcherAssert.assertThat("Error: the faqs shown are not for Europe mainland",
                faQsPage.getFaqTittle().contains("mainland Europe"), CoreMatchers.equalTo(true));
    }
}
