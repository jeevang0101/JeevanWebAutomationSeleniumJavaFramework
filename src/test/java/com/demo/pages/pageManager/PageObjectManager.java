package com.demo.pages.pageManager;

import com.demo.pages.CartPage;
import com.demo.pages.HomePage;
import com.demo.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private HomePage homePage;
    private CartPage cartPage;
    private ProductPage productPage;
    private WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public CartPage getCartPage(){
        return new CartPage(driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage(driver);
    }
}
