package com.project.saucedemo;

import basesetup.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    ValidateHelpers validateHelpers;
    public LoginPage(WebDriver driver) { //truyền vào driver đã khởi tạo ở BaseSetup
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    //Element at Login Page
    private By usernameInput = By.xpath("//input[@id='user-name']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginBtn = By.xpath("//input[@id='login-button']");


    public void login(String username, String password) {
        validateHelpers.setText(usernameInput,username);
        validateHelpers.setText(passwordInput,password);
        validateHelpers.clickElement(loginBtn);
    }
}
