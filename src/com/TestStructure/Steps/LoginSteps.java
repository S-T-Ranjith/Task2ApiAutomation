package com.TestStructure.Steps;

import com.TestStructure.Actions.ApiAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginSteps {


    @Given("User set {string} service endpoint")
    public void userSetServiceEndpoints(String endpoint) throws MalformedURLException {
        ApiAction.setServiceEndpoint(endpoint);
    }

    @When("User perform {string} request type for {string}")
    public void userPerformRequestType(String requestType, String apiName) throws IOException {
        ApiAction.setRequestType(requestType, apiName);
    }

    @Then("User receives valid response code")
    public void userReceivesValidResponseCode() throws IOException {
        ApiAction.checkStatusCode();
    }

    @Then("User verify sample response")
    public void userVerifySampleResponse() throws IOException {
        ApiAction.verifyResponseBody();
    }
}
