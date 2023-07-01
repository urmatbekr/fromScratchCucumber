package com.test.saucedemo.stepdefinitions;

import com.test.saucedemo.pages.CartPage;
import com.test.saucedemo.pages.CheckoutPage;
import com.test.saucedemo.pages.LoginPage;
import com.test.saucedemo.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class OrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    CartPage cartPage = new CartPage(driver);

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("User provides username and password to login successfully")
    public void userProvidesUsernameAndPasswordToLoginSuccessfully() {
        loginPage.login(ConfigReader.redProperty("QA_username"),
                ConfigReader.redProperty("QA_password"));
    }
    @When("User chooses the {string},click add to cart button and validate it is added")
    public void userChoosesTheClickAddToCartButtonAndValidateItIsAdded(String productName) throws InterruptedException {
        mainPage.chooseProduct(productName);
        mainPage.addingProductToCart();
    }
    @When("User clicks cart icon and checkout button")
    public void userClicksCartIconAndCheckoutButton() {
        mainPage.clickCartButton();
        cartPage.clickCheckoutButton(driver);
    }
    @When("User provides {string},{string},{string} to checkout page and click continue button")
    public void userProvidesToCheckoutPageAndClickContinueButton(String firstname, String lastname, String zipCode) {
        checkoutPage.sendUserInformation(firstname, lastname, zipCode);
    }
    @Then("User validates the {string},{string},{string},{string} with {string}% tax rate")
    public void userValidatesTheWithTaxRate(String productName, String itemTotal, String tax,
                                            String TotalPrice, String taxRate) {
        checkoutPage.validateItemOrderInformation();
    }
    @Then("User clicks Finish Button and validate {string} for purchase")
    public void userClicksFinishButtonAndValidateForPurchase(String string) {

    }

}
