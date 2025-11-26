package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "signin2")
    private WebElement headerSignUpLink;

    @FindBy (xpath = "//a[contains(@class, 'ico-')]")
    private List<WebElement> categotyOptions;

    @FindBy (id = "cat")
    private WebElement productsCategorySection;

    @FindBy(css = "a#itemc")
    private List<WebElement> productCategories;

    @FindBy (css = "a.hrefch")
    private List<WebElement> productCardTitles;

    public boolean headerSignUpLinkIsDisplayed(){
        return waitForElementDisplayed(headerSignUpLink);
    }

    public boolean productsCategorySectionIsDisplayed(){
        return waitForElementDisplayed(productsCategorySection);
    }

    public List<String> getProductCategories(){
        return getTextOfAllElements(productCategories);
    }

    public void scrollToProductsCategory(){
        scrollToElement(productsCategorySection);
    }

    public void clickOnProductCategory(String category){
        clickOnElementWithText(productCategories, category);
    }

    public void selectProduct(String productName){
        waitUntilElementsLoad(productCardTitles);
        clickOnElementWithText(productCardTitles, productName);
    }

    public void waitForVisibilityOfProducts(){
        waitForVisibilityOfAllElements(productCardTitles);
    }
}
