package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy (css = "tr.success")
    private WebElement cartItem;

    @FindBy (xpath = "//tr[@class='success']/td[2]")
    private List<WebElement> cartProductTitles;

    public boolean cartPageIsDisplayed(){
        return waitForVisibilityOfElement(cartItem).isDisplayed();
    }

    public boolean isCartContainsProduct(String product){
        return getTextOfAllElements(cartProductTitles).contains(product);

    }
}
