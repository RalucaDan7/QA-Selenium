package pages;

import base.DriverUtil;
import common.WaitUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserScreenPage {

    @FindBy(css = "button[id=\"buy-now-btn\"]")
    private WebElement buyNowButton;

    @FindBy(css = "input[name=\"fullName\"]")
    private WebElement fullNameField;

    @FindBy(css = "input[name=\"address\"]")
    private WebElement addressField;

    @FindBy(css = "input[name=\"contactNumber\"]")
    private WebElement contactNumberField;

    @FindBy(css = "input[id=\"input-quantity\"]")
    private WebElement quantityField;

    @FindBy(css = "button[id=\"place-order-btn\"]")
    private WebElement placeOrderButton;

    @FindBy(css = "button[id=\"logout-btn\"]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button/span[contains(text(),\"Login\")]")
    private WebElement homePageLoginButton;

    @FindBy(xpath = "//button/span[contains(text(),\"Home\")]")
    private WebElement homeButton;

    @FindBy(css = "span[id=\"company-name\"]")
    private WebElement depozitMaterialeDeConstructiiTitleFromHeader;

    @FindBy(xpath = "//button/span[contains(text(),\"Products\")]")
    private WebElement productsButton;

    @FindBy(css = "button[class*=\"view-details-btn\"]")
    private List<WebElement> viewDetailsButton;

    @FindBy(css = "p[class=\"product-name\"]")
    private List<WebElement> productNameTitle;

    @FindBy(css = "mat-select[id=\"select-filter-category\"]")
    private WebElement categoryDropdownButton;

    @FindBy(css = "span[class=\"mdc-list-item__primary-text\"]")
    private List<WebElement> categoryList;

    @FindBy(css = "p[class=\"product-category\"]")
    private List<WebElement> productTypeList;

    @FindBy(xpath = "//button/span[contains(text(),\"Add to cart\")]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button/span[contains(text(),\"Cart\")]")
    private WebElement cartButton;

    public void clickOnProductsButton() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", productsButton);
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), productsButton);
        js.executeScript("arguments[0].click();", productsButton);
    }

    public void clickOnViewDetailsButton(String productName) {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        for (WebElement text : productNameTitle) {
            if (text.getText().contains(productName)) {
                int i = productNameTitle.indexOf(text);
                js.executeScript("arguments[0].scrollIntoView();", viewDetailsButton.get(i));
                WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), viewDetailsButton.get(i));
                js.executeScript("arguments[0].click();", viewDetailsButton.get(i));
            }
        }
    }

    public void checkProductIsDisplayedOnIndividualPage(String productName) {
        WebElement productTitleProductPage = DriverUtil.getDriver().findElement(By.xpath("//div/div/h2"));
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), productTitleProductPage);
        Assert.assertTrue(productName + "is not displayed", productTitleProductPage.getText().contains(productName));
    }


    public void clickOnBuyNowButton() {
        buyNowButton.click();
    }

    public void clickOnFullNameFieldAndType(String fullName) {
        fullNameField.click();
        fullNameField.sendKeys(fullName);
    }

    public void clickOnAddressFieldAndType(String address) {
        addressField.click();
        addressField.sendKeys(address);
    }

    public void clickOnContactNumberFieldAndType(String number) {
        contactNumberField.click();
        contactNumberField.sendKeys(number);
    }

    public void clickOnQuantityFieldAndType(String quantity) {
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void checkLoginButton() {
        Assert.assertTrue("Logout is not functioning", homePageLoginButton.isDisplayed());
    }

    public void clickOnDepozitMaterialeDeConstrunctiiFromHeader() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", depozitMaterialeDeConstructiiTitleFromHeader);
        js.executeScript("arguments[0].click();", depozitMaterialeDeConstructiiTitleFromHeader);
        Assert.assertTrue("The title from header is not redirecting you", homeButton.isDisplayed());
    }

    public void clickOnRefreshButton() {
        DriverUtil.getDriver().navigate().refresh();
    }

    public void clickOnCategoryDropdownButton() {
        categoryDropdownButton.click();
    }

    public void selectProductType(String productType) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getText().contains(productType)) {
                WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), categoryList.get(i));
                categoryList.get(i).click();
            }
        }
    }

    public void checkDisplayedProducts(String productType) {
        boolean found = false;
        for (WebElement type : productTypeList) {
            if (type.getText().contains(productType)) {
                found = true;
                Assert.assertTrue(type.getText().contains(productType));
            }
        }
        if (!found) {
            System.out.println("The filter is not functioning");
        }
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCartButton() {
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", cartButton);
        WaitUtils.waitForVisibilityOfElement(DriverUtil.getDriver(), cartButton);
        js.executeScript("arguments[0].click();", cartButton);
    }

    public void checkProductIsInTheCart(String productName) {
        List<WebElement> nameFromCartList = DriverUtil.getDriver().findElements(By.cssSelector("td[class=\"mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-name mat-column-name ng-star-inserted\"]"));
        boolean found = false;
        for (WebElement nameFromCart : nameFromCartList) {
            if (nameFromCart.getText().contains(productName)) {
                found = true;
                Assert.assertTrue(nameFromCart.getText().contains("productName"));
            }
        }
        if (!found) {
            System.out.println(productName + " was not added to the cart");
        }
    }

}