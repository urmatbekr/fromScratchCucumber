package com.test.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {
    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".inventory_item_name")
    private List <WebElement> allProducts;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private WebElement addCartButton;

    @FindBy (css = "#shopping_cart_container")
    private WebElement cartIcon;

    public void chooseProduct(String productName){
        for (WebElement product: allProducts
             ) {
            if (BrowserUtils.getText(product).equals(productName)){
                product.click();
                break;
            }
        }
    }

    public void addingProductToCart() throws InterruptedException {
        Assert.assertTrue(BrowserUtils.getText(cartIcon).isEmpty());
        addCartButton.click();
        Thread.sleep(500);
        Assert.assertFalse(BrowserUtils.getText(cartIcon).isEmpty());
    }

    public void clickCartButton(){
        cartIcon.click();
    }

}
