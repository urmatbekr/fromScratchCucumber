package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    public CartPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    public void clickCheckoutButton(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        checkoutButton=wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();

    }



}
