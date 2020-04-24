package com.weborders.pages;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 30);

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='View all orders']")
    private WebElement viewAllOrders;

    @FindBy(xpath = "//a[text()='View all products']")
    private WebElement viewAllProducts;

    @FindBy(xpath = "//a[text()='Order']")
    private WebElement order;

    /**
     *
     * @param module
     */
    public void navigateTo1(String module){
        String locator="//a[text()='"+module+"']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    /**
     *
     * @param module
     */
    public void navigateTo2(String module) {
        BrowserUtilities.wait(2);
        if (module.equalsIgnoreCase("View all orders")) {
            viewAllOrders.click();
        } else if (module.equalsIgnoreCase("View all products")) {
            viewAllProducts.click();
        } else if (module.equalsIgnoreCase("Order")) {
            order.click();
        }
        BrowserUtilities.wait(2);
    }



}

