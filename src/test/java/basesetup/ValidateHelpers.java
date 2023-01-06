package basesetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateHelpers {
    private WebDriver driver;

    public ValidateHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public boolean verifyURL(String url) {
        return driver.getCurrentUrl().contains(url);
    }

    public boolean verifyElementText(By element, String text) {
        return driver.findElement(element).getText().equals(text);
    }

    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }
}

