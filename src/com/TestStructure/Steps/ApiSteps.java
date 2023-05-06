package src.com.TestStructure.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import src.com.TestStructure.Actions.ApiAction;

import java.io.IOException;
import java.net.MalformedURLException;

public class ApiSteps {

    @When("User perform {string} request type for {string}")
    public void userPerformRequestType(String requestType, String apiName) throws IOException {
        ApiAction.setRequestType(requestType, apiName);
    }

    @Given("User set {string} service endpoint")
    public void userSetServiceEndpoint(String endPoint) throws MalformedURLException {
        ApiAction.setServiceEndpoint(endPoint);
    }

    @And("User verifies the request path for {string}")
    public void userVerifiesTheRequestPathFor(String apiName) throws IOException {
        ApiAction.checkPathURL(apiName);
    }

    @And("User verifies the response code for {string}")
    public void userVerifiesTheResponseCodeFor(String apiName) throws IOException {
        ApiAction.checkStatusCode(apiName);
    }

    @And("User verifies the response data for {string}")
    public void userVerifiesTheResponseDataFor(String apiName) throws IOException {
        ApiAction.verifyResponseBody(apiName);
    }
}
