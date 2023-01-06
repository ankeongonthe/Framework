package com.project.saucedemo;

import basesetup.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Checkout_Complete {
    WebDriver driver;
    ValidateHelpers validateHelpers;
    By pageTitle = By.xpath("//span[contains(text(),'Checkout: Complete!')]");
    By containTxt = By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]");
    By backHomeBtn = By.xpath("//button[@id='back-to-products']");
    By completeTxt = By.xpath("//div[@class='complete-text']");

    public Checkout_Complete(WebDriver driver){
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    public void Complete() {
        String actTitle = "CHECKOUT: COMPLETE!";
        Assert.assertTrue(validateHelpers.verifyElementText(pageTitle, actTitle), "Page Title does not match");

        String actualTitle = "THANK YOU FOR YOUR ORDER";
        Assert.assertTrue(validateHelpers.verifyElementText(containTxt, actualTitle), "Title does not match");

        System.out.println(validateHelpers.getElementText(completeTxt));

        validateHelpers.clickElement(backHomeBtn);
    }
}

