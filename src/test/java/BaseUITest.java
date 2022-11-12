import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseUITest {

    protected WebDriver webDriver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
