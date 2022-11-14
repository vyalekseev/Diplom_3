import api.DeleteUserMethods;
import api.LoginUserMethods;
import api.LoginUserRequest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static api.LoginUserGenerator.loginUser;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

public abstract class BaseUITest {

    protected WebDriver webDriver;
    public String name;
    public String email;
    public String password;
    private DeleteUserMethods deleteUserMethods;
    private LoginUserMethods loginUserMethods;
    private String bearerToken;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

//        System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        webDriver= new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://stellarburgers.nomoreparties.site/");

        deleteUserMethods = new DeleteUserMethods();
        loginUserMethods = new LoginUserMethods();

        name = RandomStringUtils.randomAlphanumeric(10);
        email = RandomStringUtils.randomAlphanumeric(5) + "@test.ru";
        password = RandomStringUtils.randomAlphanumeric(6);

    }

    @After
    public void tearDown() {
        webDriver.quit();
        try {
            LoginUserRequest randomUser = loginUser(name, email, password);
            String accessToken = loginUserMethods.login(randomUser)
                    .assertThat()
                    .statusCode(SC_OK)
                    .and()
                    .body("success", equalTo(true))
                    .extract()
                    .path("accessToken");
            bearerToken = accessToken.replaceAll("Bearer ", "");
        } catch (java.lang.AssertionError e) {
            System.out.println("Авторизация не нужна");
        }


        if (bearerToken != null) {
            deleteUserMethods.delete(bearerToken)
                    .assertThat()
                    .body("success", equalTo(true));
        }
    }
}
