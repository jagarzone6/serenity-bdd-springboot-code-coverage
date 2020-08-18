package com.example.cucumber.steps;

import com.restapiserenitycucumberscreenplay.screenplay.tasks.get.GetAppMessage;
import com.restapiserenitycucumberscreenplay.screenplay.tasks.get.GetAppStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class MessageStepdefs {

    @Given("^The service is up$")
    public void theServiceWasUp() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetAppStatus.fromAPI());
        OnStage.theActorInTheSpotlight().should(seeThat(actor -> SerenityRest.lastResponse().getStatusCode(), equalTo(200)));
        OnStage.theActorInTheSpotlight().should(seeThat(GetAppStatus.getStatus(), equalTo("UP")));
    }

    @When("^I ask for the user message$")
    public void iTryToAddANewUserWithNameAndLastName() {
        OnStage.theActorInTheSpotlight().attemptsTo(GetAppMessage.fromAPI());
    }

    @Then("^I should see message \"(.*)\"$")
    public void iShouldSeeThatTheNewUserWasAddedSuccesfully(String message) {
        OnStage.theActorInTheSpotlight().should(seeThat(actor -> SerenityRest.lastResponse().getStatusCode(), equalTo(200)));
        OnStage.theActorInTheSpotlight().should(seeThat(actor -> SerenityRest.lastResponse().body().asString(), equalTo(message)));
    }
}
