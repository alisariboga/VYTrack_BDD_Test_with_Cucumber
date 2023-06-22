package com.vytrack.step_definitions;

import com.vytrack.utilities.Pages;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class VehiclesStepDefinitions {
    Pages pages = new Pages();

    @Then("user verifies that default page number is {int}")
    public void user_verifies_that_default_page_number_is(Integer expected) {
        Assert.assertEquals(Optional.ofNullable(expected), pages.vehiclesPage().getPageNumber());

    }

    @Then("user clicks on the create a car button")
    public void user_clicks_on_create_car_button() {
        pages.vehiclesPage().clickToCreateACar();
    }

    @Then("user enters car information:")
    public void user_enters_car_information(Map<String, String> values) {
        //Before reading a data table we can verify if such a key-value pair exist
//        if(values.containsKey("License Plate"))
        pages.vehiclesPage().enterLicensePlate(values.get("License Plate"));
        pages.vehiclesPage().driverInput.sendKeys(values.get("Driver"));
        pages.vehiclesPage().enterLocation(values.get("Location"));
        pages.vehiclesPage().enterModelYear(values.get("Model Year"));
        pages.vehiclesPage().enterColor(values.get("Color"));
        pages.vehiclesPage().enterPower(values.get("Power"));
    }


    @Then("user enters car information to create a car")
    public void user_enters_car_information_to_create_a_car(List<Map<String, String>> values) {
        //values.get(0).get("Driver");
        for (Map<String, String> value : values) {
            pages.vehiclesPage().enterLicensePlate(value.get("License Plate"));
            pages.vehiclesPage().driverInput.sendKeys(value.get("Driver"));
            pages.vehiclesPage().enterLocation(value.get("Location"));
            pages.vehiclesPage().enterModelYear(value.get("Model Year"));
            pages.vehiclesPage().enterColor(value.get("Color"));
            pages.vehiclesPage().enterPower(value.get("Power"));
        }
    }

    @Then("user clicks save and close")
    public void user_clicks_save_and_close() {
        pages.vehiclesPage().clickSaveAndClose();
    }

    @Then("user verifies that general information is displayed")
    public void user_verifies_that_general_information_is_displayed() {
        Assert.assertTrue(pages.vehiclesPage().verifyGeneralInformationIsDisplayed());
    }
}
