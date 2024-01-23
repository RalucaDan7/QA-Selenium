package steps;

import baseTest.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AdminScreenSteps extends BaseTest {
    @And("Click on Add new product button")
    public void clickOnAddNewProductButton() {
        adminScreenPage.clickOnAddNewProductButton();
    }

    @And("Click on Product name field and type {string}")
    public void clickOnProductNameFieldAndType(String productName) {
        adminScreenPage.clickOnProductNameFieldAndType(productName);
    }

    @And("Click on Product description field and type {string}")
    public void clickOnProductDescriptionFieldAndType(String productDescription) {
        adminScreenPage.clickOnProductDescriptionFieldAndType(productDescription);
    }

    @And("Click on Product Action Price and type {string}")
    public void clickOnProductActionPriceFieldAndType(String productActionPrice) {
        adminScreenPage.clickOnProductActionPriceFieldAndType(productActionPrice);
    }

    @And("Click on Product Discounted Price and type {string}")
    public void clickOnProductDiscountedPriceFieldAndType(String productDiscountedPrice) {
        adminScreenPage.clickOnProductDiscountedPriceFieldAndType(productDiscountedPrice);
    }

    @And("Drag and drop a file in the specific box")
    public void dragAndDropFile(){
        adminScreenPage.dragAndDropFile();
    }

    @And("Click on Add Product Button")
    public void addProduct(){
        adminScreenPage.addProduct();
    }

    @Then("Check {string} is displayed")
    public void checkProductIsDisplayed(String product){
        adminScreenPage.checkProductIsDisplayed(product);
    }
}
