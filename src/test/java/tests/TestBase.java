package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    @Parameters("browserName")
    public void startUp(@Optional("chrome") String browserName){

        if (browserName.equalsIgnoreCase("chrome")){
            String driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("headless")){
            String driverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/phantomjs";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String[] phantomJsArgs = {"--web-security=no" , "--ignore-ssl-errors=yes"};
            //capabilities.setJavascriptEnabled(true);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, driverPath);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
            driver = new PhantomJSDriver(capabilities);
        }else if(browserName.equalsIgnoreCase("chrome-headless")) {
            String chromeDriverPath = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
