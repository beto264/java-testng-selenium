package cl.dev.testing;

import cl.dev.testing.config.LogListener;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class AppTest 
    extends TestCase
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LogListener.class);
    private static final String WEB_URL = "http://www.google.com";

    private WebDriver driver;

    @BeforeTest
    public void setupTest (){
        driver = new ChromeDriver();
        driver.navigate().to(WEB_URL);
    }

    @Test(testName = "firstTest")
    public void firstTest () {
        String title = driver.getTitle();
        LOGGER.info("title => " + title);
        Assert.assertEquals(title, title, "Google");
    }

    @AfterMethod
    public void teardownTest (){
        driver.quit();
    }
}
