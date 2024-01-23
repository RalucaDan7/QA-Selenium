package pages;

import base.DriverUtil;
import common.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AdminScreenPage {

    @FindBy(xpath = "(//button[@id=\"add-new-product-btn\"])")
    private WebElement addNewProductButton;

    @FindBy(css = "input[name=\"name\"]")
    private WebElement productNameField;

    @FindBy(css = "input[name=\"description\"]")
    private WebElement productDescriptionField;

    @FindBy(css = "input[name=\"price\"]")
    private WebElement productActionPriceField;

    @FindBy(css = "input[name=\"discountedPrice\"]")
    private WebElement productDiscountedPriceField;

    @FindBy(css = "input[type=\"file\"]")
    private WebElement dragAndDropBox;

    @FindBy(css = "button[id=\"add-product-btn\"]")
    private WebElement addProductButton;

    @FindBy(xpath = "//button/span[contains(text(),\"Products\")]")
    private WebElement productsButton;


    public void clickOnAddNewProductButton() {
        WaitUtils.waitForPageToLoad();
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), addNewProductButton);
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(addNewProductButton).click().build().perform();
    }

    public void clickOnProductNameFieldAndType(String productName) {
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), productNameField);
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(productNameField).click().build().perform();
        productNameField.sendKeys(productName);
    }

    public void clickOnProductDescriptionFieldAndType(String productDescription) {
        Actions action = new Actions(DriverUtil.getDriver());
        action.moveToElement(productDescriptionField).click().build().perform();
        productDescriptionField.sendKeys(productDescription);
    }

    public void clickOnProductActionPriceFieldAndType(String productActionPrice) {
        productActionPriceField.click();
        productActionPriceField.clear();
        productActionPriceField.sendKeys(productActionPrice);
    }

    public void clickOnProductDiscountedPriceFieldAndType(String productDiscountedPrice) {
        productDiscountedPriceField.click();
        productDiscountedPriceField.clear();
        productDiscountedPriceField.sendKeys(productDiscountedPrice);
    }

    public void dragAndDropFile() {
        dragAndDropBox.sendKeys("C:\\Users\\Lenovo\\Desktop\\produse site\\silicon");
    }

    public void addProduct() {
        addProductButton.click();
    }

    public void checkProductIsDisplayed(String product) {
        List<WebElement> productTextList = DriverUtil.getDriver().findElements(By.cssSelector("p[class=\"product-name\"]"));
        boolean found=false;
        for (WebElement text : productTextList) {
            if (text.getText().contains(product)) {
                found=true;
                Assert.assertEquals( product, text.getText());
                break;
            }
        }
        if(!found){
            System.out.println(product + "was not found on Products page");
        }
    }
}