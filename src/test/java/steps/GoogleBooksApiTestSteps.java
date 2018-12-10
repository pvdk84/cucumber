package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class GoogleBooksApiTestSteps {

    private Response response = null;
    private RequestSpecification request = null;
    private String ENDPOINT = null;

    @Given("^that I want to search for a book through the Google Books API$")
    public void setUpGoogleApi() {
        ENDPOINT = "https://www.googleapis.com/books/v1/volumes";
    }

    @When("^I place a request with the search parameter \"([^\"]*)\"$")
    public void placeRequest(String parameter) {
        request = given().param("q", parameter);
    }

    @Then("^the response should have statuscode \"([^\"]*)\"$")
    public void checkResponseStatuscode(String statusCode) {
        response = request.when().get(ENDPOINT);

        // check response statuscode
        int expectedStatusCode = Integer.parseInt(statusCode);
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("^the response should include a book with the following data$")
    public void checkResponseBody(Map<String, String> responseMap) {

        // in the actual response, authors are in a list
        // so the expected authors must also be a list
        List<String> authorsList = Arrays.asList(responseMap.get("authors").split(","));

        // check response
        for (Map.Entry<String, String> entry : responseMap.entrySet()) {
            String key = "items.volumeInfo." + entry.getKey();

            // two ways to check response
            if (entry.getKey().equalsIgnoreCase("authors")) {
                response.then().body(key, hasItem(authorsList)); // one option
                Assert.assertThat(response.jsonPath().get(key), hasItem(authorsList)); // other option
            } else {
                response.then().body(key, hasItem(entry.getValue()));
                Assert.assertThat(response.jsonPath().get(key), hasItem(entry.getValue()));
            }
        }
    }
}
