package com.demo.stepDefinitions;

import com.demo.context.TestContext;
import com.demo.pages.HomePage;
import com.demo.pages.pageManager.PageObjectManager;
import com.demo.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class HomeStepDefinitions {
    private final HomePage homePage;

    public HomeStepDefinitions(TestContext testContext){
        this.homePage = new PageObjectManager(testContext.driver).getHomePage();
    }

    @Given("I am on Home page")
    public void i_am_on_home_page() {
        homePage.openPage(ConfigReader.getConfigReader().getProperty("url"));
        Assert.assertEquals(homePage.getPageTitle(), "STORE", "Home Page Title Didn't Match");
    }

    @Given("I am a guest user")
    public void i_am_a_guest_user() {
        Assert.assertTrue(homePage.headerSignUpLinkIsDisplayed());
    }

    @When("I am viewing home product category section")
    public void i_am_viewing_home_product_category_section() {
        Assert.assertTrue(homePage.productsCategorySectionIsDisplayed());
    }

    @Then("I expect to see following product categories")
    public void i_expect_to_see_following_product_categories(List<String> categories) {
        Assert.assertTrue(homePage.getProductCategories().containsAll(categories), "Product categories not matching");
    }

    @When("I click on {string} category")
    public void i_click_on_category(String category) {
        homePage.scrollToProductsCategory();
        homePage.clickOnProductCategory(category);
    }

    @When("I select {string} product")
    public void i_select_product(String productName) {
        homePage.selectProduct(productName);
    }
}
