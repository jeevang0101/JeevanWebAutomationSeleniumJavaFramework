package com.demo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url){
        driver.get(url);
//        wait.until(d -> ((JavascriptExecutor) d)
//                        .executeScript("return document.readyState").equals("complete"));
    }

    protected void quitPage(){
        driver.quit();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    protected String getTextOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected List<String> getTextOfAllElements(List<WebElement> elements){
        return elements.stream()
                .map(element -> element.getText().trim())
                .collect(Collectors.toList());
    }

    protected boolean isElementDisplayed(WebElement element){
        return waitForVisibilityOfElement(element).isDisplayed();
    }

    protected WebElement waitForVisibilityOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected List<WebElement> waitForVisibilityOfAllElements(List<WebElement> elements){
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    protected boolean waitForElementDisplayed(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected void clickOnElement(WebElement element){
        element.click();
    }

    protected Boolean waitUntilElementsLoad(List<WebElement> elements){
        return wait.until(d -> elements.size() > 1);
    }

    protected void clickOnElementWithText(List<WebElement> elements, String elementText){
        elements.stream()
                .filter(element -> elementText.equals(element.getText().trim()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text : " + elementText + " not found !!!"))
                .click();
    }

    protected void waitAndClickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected Alert getAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected String getAlertText(){
        return getAlert().getText();
    }

    protected void acceptAlert(){
        getAlert().accept();
    }

    protected void dismissAlert(){
        getAlert().dismiss();
    }
}
