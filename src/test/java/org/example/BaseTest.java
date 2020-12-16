package org.example;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

    private String URL="https://www.amazon.com/";
    protected String selectBrowser = "chrome";
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);


    @BeforeScenario
    public void beforeMethod(){
        PropertyConfigurator.configure("log4j.properties");
        if (selectBrowser.equalsIgnoreCase("chrome")){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
            driver=new ChromeDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get(URL);
        }
        else if (selectBrowser.equalsIgnoreCase("firefox")){
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
            driver=new FirefoxDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get(URL);
        }
        else{
            Assert.fail("Driver bulunamadı.");
        }
    }

    @AfterScenario
    public void tearDown(){
        if (driver!=null) {
            driver.quit();
        }
    }

}
