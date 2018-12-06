package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.CalculatorUnitTestObjects;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTestSteps {

    private CalculatorUnitTestObjects calculator = null;
    private String result = null;

    @Given("^that I have a calculator$")
    public void initCalculator() {
        calculator = new CalculatorUnitTestObjects();
    }


    @When("^I perform the function (.*?) with the numbers (.*?) and (.*?)$")
    public void calculateResult(String function, String x, String y) {
        result = calculator.calculate(function, Integer.parseInt(x), Integer.parseInt(y));
    }

    @Then("^the calculator should give the result (.*?)$")
    public void checkResult(String expected) {
        assertEquals(expected, result);
    }

    @After
    public void breakDown() {
        calculator = null;
        result = null;
    }
}
