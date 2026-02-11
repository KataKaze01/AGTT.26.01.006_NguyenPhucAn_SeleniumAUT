package Railway;

import Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.google.common.base.Ascii.equalsIgnoreCase;

public class BaseTest {
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser){
        System.out.println("Pre-condition");
        String runBrowser = System.getProperty("browser", browser);

        if ("chrome".equalsIgnoreCase(runBrowser)){
            Constant.WEBDRIVER = new ChromeDriver();
        }else if ("firefox".equalsIgnoreCase(runBrowser)){
            Constant.WEBDRIVER = new FirefoxDriver();
        }else {
            throw new RuntimeException("Unsupported browser: " + runBrowser);
        }
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}