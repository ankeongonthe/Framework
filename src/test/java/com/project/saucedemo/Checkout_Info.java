package com.project.saucedemo;

import basesetup.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout_Info {
    WebDriver driver;
    ValidateHelpers validateHelpers;
    public Checkout_Info(WebDriver driver){
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }
    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By zipCode = By.xpath("//input[@id='postal-code']");
    By continueBtn = By.xpath("//input[@id='continue']");

    public void information(String fname, String lname, String zipcode) {
        validateHelpers.setText(firstName,fname);
        validateHelpers.setText(lastName,lname);
        validateHelpers.setText(zipCode,zipcode);
        validateHelpers.clickElement(continueBtn);
    }
}
