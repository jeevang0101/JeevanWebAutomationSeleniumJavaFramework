package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy (css = "h2.name")
    private WebElement productPageTitle;

    @FindBy (xpath = "//a[contains(@class, 'btn-success')]")
    private WebElement addToCartButton;

    @FindBy (css = "a.nav-link")
    private List<WebElement> headerLinks;

    public String getProductPageTitle(){
        return getTextOfElement(productPageTitle);
    }

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public String getAddToCartAlertMessage(){
        return getAlertText();
    }

    public void acceptAddToCartAlert(){
        acceptAlert();
    }

    public void clickOnHeaderLink(String link){
        clickOnElementWithText(headerLinks, link);
    }

}
