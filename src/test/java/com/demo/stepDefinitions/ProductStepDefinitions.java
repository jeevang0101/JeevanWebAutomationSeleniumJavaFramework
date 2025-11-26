package com.demo.stepDefinitions;

import com.demo.context.TestContext;
import com.demo.pages.ProductPage;
import com.demo.pages.pageManager.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductStepDefinitions {
    private final ProductPage productPage;

    public ProductStepDefinitions(TestContext testContext){
        this.productPage = new PageObjectManager(testContext.driver).getProductPage();
    }

    @Then("I expect to navigate to {string} product details page")
    public void i_expect_to_navigate_to_product_details_page(String productName) {
        Assert.assertEquals(productPage.getProductPageTitle(), productName);
    }

    @When("I click on Add to cart button")
    public void i_click_on_button() {
        productPage.clickOnAddToCartButton();
    }

    @Then("I expect to see {string} alert")
    public void i_expect_to_see_alert(String message) {
        Assert.assertEquals(productPage.getAddToCartAlertMessage(), message);
    }

    @Then("I accept the alert")
    public void i_accept_the_alert() {
        productPage.acceptAddToCartAlert();
    }

    @When("I click on {string} header link")
    public void i_click_on_header_link(String link) {
        productPage.clickOnHeaderLink(link);
    }
}
