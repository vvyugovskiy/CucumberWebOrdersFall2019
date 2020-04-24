package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement product;

    @FindBy(name = "ctl00$MainContent$fmwOrder$txtQuantity")
    private WebElement quantityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    private WebElement pricePerUnitInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    private WebElement discountInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    private WebElement totalInput;

    @FindBy(css = "input[type='submit']")
    private WebElement calculateButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerNameInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement ziCodeInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visaCheckboxCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    private WebElement masterCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    private WebElement amexCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNumberInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expireDateInput;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;

    @FindBy(css = "input[type='reset']")
    private WebElement resetButton;

    public void setProduct(String productText) {
        Select selectProduct = new Select(product);
        selectProduct.selectByVisibleText(productText);
    }

    public void setQuantity(String quantity) {
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(quantityInput)).sendKeys(quantity);
    }

    public void setPricePerUnit(String pricePerUnit) {
        wait.until(ExpectedConditions.visibilityOf(pricePerUnitInput));
        if (!pricePerUnitInput.equals(pricePerUnit)) {
            pricePerUnitInput.clear();
            pricePerUnitInput.sendKeys(pricePerUnit);
        }

    }

    public void setDiscount(String discount) {
        wait.until(ExpectedConditions.visibilityOf(discountInput));
        if (!discountInput.equals(discount)) {
            discountInput.clear();
            discountInput.sendKeys(discount);
        }
    }

    public void clickOnCalculateButton() {
        wait.until(ExpectedConditions.visibilityOf(calculateButton)).click();
    }

    public String totalVerify() {
        wait.until(ExpectedConditions.visibilityOf(totalInput));
        System.out.println(totalInput.getAttribute("value"));
        return totalInput.getAttribute("value");
    }

    public void setCustomerName(String customerName) {
        wait.until(ExpectedConditions.visibilityOf(customerNameInput)).sendKeys(customerName);
    }

    public void setStreet(String street) {
        wait.until(ExpectedConditions.visibilityOf(streetInput)).sendKeys(street);
    }

    public void setCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityInput)).sendKeys(city);
    }

    public void setState(String state) {
        wait.until(ExpectedConditions.visibilityOf(stateInput)).sendKeys(state);
    }

    public void setZip(String zip) {
        wait.until(ExpectedConditions.visibilityOf(ziCodeInput)).sendKeys(zip);
    }

    public void setCardType (String cardType){
        String locator = "//input[@name='ctl00$MainContent$fmwOrder$cardList'][@value='"+cardType+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    public void setCardNumber (String cardNumber){
        wait.until(ExpectedConditions.visibilityOf(cardNumberInput)).sendKeys(cardNumber);
    }

    public void setExpireDate (String expireDate) {
        wait.until(ExpectedConditions.visibilityOf(expireDateInput)).sendKeys(expireDate);
    }

    public void clickOnProcessButton () {
        wait.until(ExpectedConditions.visibilityOf(processButton)).click();
    }

    public String getName (String tab){
        String locator = "//table//th[text()='"+tab+"']//following::td[2]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return driver.findElement(By.xpath(locator)).getText().trim();
    }
    public String getProduct (String tab){
        String locator = "//table//th[text()='"+tab+"']//following::td[3]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        return driver.findElement(By.xpath(locator)).getText().trim();

    }
}

