package com.project.saucedemo;

import basesetup.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
    WebDriver driver;
    ValidateHelpers validateHelpers;
    public ProductsPage(WebDriver driver) { //truyền vào driver đã khởi tạo ở BaseSetup
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    //Element at Product Page
    By firstItem = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
    By addBtn = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");

    public void products() {
        String actName = "Sauce Labs Backpack";
        Assert.assertTrue(validateHelpers.verifyElementText(firstItem,actName),"Tên sản phẩm không trùng khớp");
        validateHelpers.clickElement(addBtn);
        validateHelpers.clickElement(shoppingCart);
    }
}
