package steps;

import baseTest.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.UserScreenPage;


public class UserScreenSteps extends BaseTest {
    @And("Click on Products button")
    public void clickOnProductsButton(){
        userScreenPage.clickOnProductsButton();
    }

    @And("Hover on {string} and click on View Details button")
    public void clickOnViewDetailsButton(String productName) {
        userScreenPage.clickOnViewDetailsButton(productName);
    }

    @Then("Check {string} is displayed on individual product page")
    public void checkProductIsDisplayedOnIndividualPage(String productName) {
        userScreenPage.checkProductIsDisplayedOnIndividualPage(productName);
    }

    @And("Click on Buy now button")
    public void clickOnBuyNowButton() {
        userScreenPage.clickOnBuyNowButton();
    }

    @And("Click on Full Name field and type {string}")
    public void clickOnFullNameFieldAndType(String fullName) {
        userScreenPage.clickOnFullNameFieldAndType(fullName);
    }

    @And("Click on Address field and type {string}")
    public void clickOnAddressFieldAndType(String address) {
        userScreenPage.clickOnAddressFieldAndType(address);
    }

    @And("Click on Contact number field and type {string}")
    public void clickOnContactNumberFieldAndType(String number) {
        userScreenPage.clickOnContactNumberFieldAndType(number);
    }

    @And("Click on Quantity field and type {string}")
    public void clickOnQuantityFieldAndType(String quantity) {
        userScreenPage.clickOnQuantityFieldAndType(quantity);
    }

    @And("Click on Place Order button")
    public void clickOnPlaceOrderButton() {
        userScreenPage.clickOnPlaceOrderButton();
    }

    @And("Click on Logout button from header")
    public void clickOnLogoutButton() {
        userScreenPage.clickOnLogoutButton();
    }

    @Then("Check Login button is visible")
    public void checkLogoutButton(){
        userScreenPage.checkLoginButton();
    }

    @And("Click on Depozit materiale de constructii from header")
    public void clickOnDepozitMaterialeDeConstrunctiiFromHeader() {
        userScreenPage.clickOnDepozitMaterialeDeConstrunctiiFromHeader();
    }

    @And("Click on refresh button")
    public void clickOnRefreshButton() {
        userScreenPage.clickOnRefreshButton();
    }

    @And("Click on Category dropdown button")
    public void clickOnCategoryDropdownButton(){
        userScreenPage.clickOnCategoryDropdownButton();
    }

    @And("Select {string}")
    public void selectProductType(String productType){
        userScreenPage.selectProductType(productType);
    }

    @Then("Check only {string} are displayed")
    public void checkDisplayedProducts(String productType){
        userScreenPage.checkDisplayedProducts(productType);
    }

    @And("Click on Add to Cart button")
    public void clickOnAddToCartButton(){
        userScreenPage.clickOnAddToCartButton();
    }

    @And("Click on Cart button from header")
    public void clickOnCartButton(){
        userScreenPage.clickOnCartButton();
    }

    @Then("Check {string} is in the cart")
    public void checkProductIsInTheCart(String productName){
        userScreenPage.checkProductIsInTheCart(productName);
    }
}
