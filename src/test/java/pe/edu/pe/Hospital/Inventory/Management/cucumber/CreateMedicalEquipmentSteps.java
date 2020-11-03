package pe.edu.pe.Hospital.Inventory.Management.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateMedicalEquipmentSteps extends SpringIntegrationTest{

    @Given("a Manager in the Medical Equipments register view")
    public void aManagerInTheMedicalEquipmentRegisterView() {

    }

    @And("the information entered is correct")
    public void theInformationEnteredIsCorrect() {
    }

    @When("the Manager clicks the register button")
    public void theManagerClicksTheRegisterButton() {
    }

    @And("make a post request to {string}")
    public void makeAPostRequestTo(String url) throws Throwable{
        executeGet(url);
    }

    @Then("the system promotes the add of the equipment")
    public void theSystemPromotesTheAddOfTheEquipment() {
    }

    @And("the result received has a status code of {int}")
    public void theResultReceivedHasAStatusCodeOf(int code) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(code));
    }

    @And("the information entered is incorrect")
    public void theInformationEnteredIsIncorrect() {
    }

    @Then("the system asks to correct the wrong data")
    public void theSystemAsksToCorrectTheWrongData() {
    }

}
