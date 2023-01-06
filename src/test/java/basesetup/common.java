package basesetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class common {
    private static WebDriver driver;
    static String chromePath = "src/core/resources/chromedriver.exe";
    static String FirefoxPath = "src/core/resources/geckodriver.exe";
    static String EdgePath = "src/core/resources/msedgedriver.exe";

    //Dùng để các class khác gọi đến nó, để nhận đc driver đã khởi tạo.
    //lấy giá trị trả về mà driver đã khởi tạo, có thể là Chrome,Firefox,...
    public static WebDriver getDriver() {
        return driver;
    }

    //Hàm này để tuỳ chọn Browser. Chạy trước khi gọi class (BeforeClass), truyền vào trong XML để chạy
    private void setDriver(String browserType, String webURL) {
        if (browserType.equals("chrome")) {
            driver = initChromeDriver(webURL);
        } else if (browserType.equals("firefox")) {
            driver = initFirefoxDriver(webURL);
        } else if (browserType.equals("edge")) {
            driver = initEdgeDriver(webURL);
        } else {
            driver = initChromeDriver(webURL);
        }
    }

    private static WebDriver initChromeDriver(String webURL) {
        System.out.println("Launching Chrome Browser...");
        System.setProperty("webdriver.chrome.driver", chromePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String webURL) {
        System.out.println("Launching FireFox Browser...");
        System.setProperty("webdriver.gecko.driver", FirefoxPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        return driver;
    }

    private static WebDriver initEdgeDriver(String webURL) {
        System.out.println("Launching FireFox Browser...");
        System.setProperty("webdriver.edge.driver", EdgePath);
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webURL);
        return driver;
    }

    @Parameters({"browserType", "webURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String webURL) {
        try {
            //Khởi tạo driver và tuỳ chọn browser và webURL
            setDriver(browserType, webURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
