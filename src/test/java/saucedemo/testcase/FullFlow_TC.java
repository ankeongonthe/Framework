package saucedemo.testcase;

import basesetup.common;
import helpers.ExcelHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.project.saucedemo.*;

public class FullFlow_TC extends common {

    //Khai báo đối tượng cho từng page
    public WebDriver driver;
    public LoginPage loginPage;
    public ProductsPage productsPage;
    public ShoppingCartPage shoppingCartPage;
    public Checkout_Overview overview;
    public Checkout_Info info;
    public Checkout_Complete complete;
    ExcelHelpers excel;

    @BeforeClass
    public void setupBrowser(){
        driver = getDriver();
        excel = new ExcelHelpers();
    }

    @Test(priority = 0)
    public void logIn() throws Exception {
        excel.setExcelFile("src/core/resources/Account.xlsx","Sheet1");
        loginPage = new LoginPage(driver); //khởi tạo đối tượng của 1 trang
        loginPage.login(excel.getCellData("Username",1),excel.getCellData("Password",1));
    }

    @Test(priority = 1)
    public void Products(){
        productsPage = new ProductsPage(driver);
        productsPage.products();
    }

    @Test(priority = 2)
    public void ShoppingCart() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.shoppingCart();
    }

    @Test(priority = 4)
    public void overView() {
        overview = new Checkout_Overview(driver);
        overview.Overview();
    }
    @Test(priority = 3)
    public void Information() {
        info = new Checkout_Info(driver);
        info.information("Nguyen","Minh","70000");
    }

    @Test(priority = 5)
    public void complete() {
        complete = new Checkout_Complete(driver);
        complete.Complete();
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
