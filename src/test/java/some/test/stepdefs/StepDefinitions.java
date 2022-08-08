package some.test.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.CucumberHacks;
import org.junit.Assert;
import org.junit.runners.model.InitializationError;

public class StepDefinitions {
    private int num1;
    private int num2;
    private int res;

    @Given("^(\\d+) and (\\d+)$")
    public void getNumbers(Integer num1, Integer num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @When("do sum")
    public void doSum() {
        res = num1 + num2;
    }

    @Then("expect {int}")
    public void expect(int arg0) {
        System.out.println(" hit that ");
        Assert.assertEquals(res, arg0);
    }


    @Given("first step")
    public void firstStep() {
        System.out.println("first step");
    }

    @Then("call {string}")
    public void call(String featureDescription) throws InitializationError {
        CucumberHacks.runFeature(featureDescription);
    }

    @Then("call {string} {string}")
    public void call(String featureDescription, String scenarioDescription) throws InitializationError {
        CucumberHacks.runScenario(featureDescription, scenarioDescription);
    }
}
