package com.project.saucedemo;

import basesetup.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPage {
    WebDriver driver;
    ValidateHelpers validateHelpers;
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }
    By product = By.xpath("//div[@class='inventory_item_name']");
    By checkoutButton = By.xpath("//button[@id='checkout']");

    public void shoppingCart() {
        String actName = "Sauce Labs Backpack";
        Assert.assertTrue(validateHelpers.verifyElementText(product,actName),"The product name does not match");
        validateHelpers.clickElement(checkoutButton);
    }
}
