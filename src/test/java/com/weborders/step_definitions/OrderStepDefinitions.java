package com.weborders.step_definitions;

import com.weborders.pages.OrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class OrderStepDefinitions {

    OrderPage orderPage = new OrderPage();

    @Given("user navigates to {string} page")
    public void user_navigates_to_page(String module) {
        orderPage.navigateTo1(module);
    }

    @When("user enters product information:")
    public void user_enters_product_information(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        for (Map<String, String> row : dataTable) {
            orderPage.setProduct(row.get("Product"));
            orderPage.setQuantity(row.get("Quantity"));
            orderPage.setPricePerUnit(row.get("Price per unit"));
            orderPage.setDiscount(row.get("Discount"));
        }
    }

    @When("user click on calculate button")
    public void user_click_on_calculate_button() {

        orderPage.clickOnCalculateButton();
    }


    @Then("user should verify that total {string} is displayed")
    public void user_should_verify_that_total_is_displayed(String total) {
        Assert.assertEquals("Total  mismatch", total, orderPage.totalVerify());
    }

    @When("user enters address information:")
    public void user_enters_address_information(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        for (Map<String, String> row : dataTable) {
            orderPage.setCustomerName(row.get("Customer name"));
            orderPage.setStreet(row.get("Street"));
            orderPage.setCity(row.get("City"));
            orderPage.setState(row.get("State"));
            orderPage.setZip(row.get("Zip"));

        }
    }

    @When("user enters payment information:")
    public void user_enters_payment_information(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        for (Map<String, String> row : dataTable) {
            orderPage.setCardType(row.get("Card"));
            orderPage.setCardNumber(row.get("Card Nr:"));
            orderPage.setExpireDate(row.get("Expire date (mm/yy)"));
        }
    }

    @When("user click on process button")
    public void user_click_on_process_button() {
        orderPage.clickOnProcessButton();
    }

    @When("use navigates to {string} page")
    public void use_navigates_to_page(String module) {
        orderPage.navigateTo1(module);
    }

    @Then("user verifies that order is displayed")
    public void user_verifies_that_order_is_displayed(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        for (Map<String, String> row : dataTable) {
            Assert.assertEquals(row.get("Name"), orderPage.getName("Name"));
            Assert.assertEquals(row.get("Product"), orderPage.getProduct("Product"));

        }
    }

}
