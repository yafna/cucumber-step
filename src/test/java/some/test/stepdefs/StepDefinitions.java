package some.test.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        res = num1  + num2;
    }

    @Then("expect {int}")
    public void expect(int arg0) {
        Assert.assertEquals(res, arg0);
    }
}
