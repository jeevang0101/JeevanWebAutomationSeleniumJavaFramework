package com.demo.stepDefinitions;

import com.demo.context.TestContext;
import com.demo.pages.CartPage;
import com.demo.pages.pageManager.PageObjectManager;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {
    private final CartPage cartPage;

    public CartStepDefinitions(TestContext testContext){
        this.cartPage = new PageObjectManager(testContext.driver).getCartPage();
    }

    @Then("I expect to navigate to cart page")
    public void i_expect_to_navigate_to_cart_page() {
        Assert.assertTrue(cartPage.cartPageIsDisplayed());
    }

    @Then("I expect to see {string} product is added to cart")
    public void i_expect_to_see_product_is_added_to_cart(String product) {
        Assert.assertTrue(cartPage.isCartContainsProduct(product));
    }
}
