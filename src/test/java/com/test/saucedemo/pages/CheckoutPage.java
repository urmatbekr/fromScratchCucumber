package com.test.saucedemo.pages;

import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#first-name")
    private WebElement firstname;

    @FindBy(css = "#last-name")
    private WebElement lastname;

    @FindBy(css = "#postal-code")
    private WebElement postalCode;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement itemTitle;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement tax;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalAmount;

    @FindBy(css = "#finish")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class]")
    private WebElement thankyouText;


    public void sendUserInformation(String firstname, String lastname, String zipCode) {
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.postalCode.sendKeys(zipCode);
        continueButton.click();
    }

    public void validateItemOrderInformation(String expectedProductName, String expectedItemTotal, String expectedTax, String expectedTotalPrice, String taxRate){

        double itemTotalConvertion=Double.parseDouble(BrowserUtils.getText(itemPrice).
                substring(BrowserUtils.getText(totalAmount).indexOf("$")+1));

        double taxConvertion=Double.parseDouble(BrowserUtils.getText(tax).
                substring(BrowserUtils.getText(tax).indexOf("$")+1));

        double totalPriceConvertion=Double.parseDouble(BrowserUtils.getText(itemPrice).
                substring(BrowserUtils.getText(totalAmount).indexOf("$")+1));

        Assert.assertEquals(expectedProductName,BrowserUtils.getText(itemTitle));
        Assert.assertEquals(expectedItemTotal,String.valueOf(itemTotalConvertion));

        double taxCalculation=itemTotalConvertion*(Double.parseDouble(taxRate)*0.01);
        System.out.println(taxCalculation);//2.40
        Assert.assertEquals(expectedTax,String.valueOf(taxCalculation));
        Assert.assertEquals(taxCalculation,taxConvertion,0.001);

        Assert.assertEquals(expectedTotalPrice,String.valueOf(totalPriceConvertion));

    }
}
