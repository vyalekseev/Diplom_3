import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends BaseUITest {
    @Test
    @DisplayName("Успешная регистрация")
    public void registrationNewUser() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(RandomStringUtils.randomAlphanumeric(10));
        mainPage.setEmailField(RandomStringUtils.randomAlphanumeric(5) + "@test.ru");
        mainPage.setPasswordField(RandomStringUtils.randomAlphanumeric(6));
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается надпись Вход", mainPage.checkAuthorizationHeader());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void registrationIncorrectPassword() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(RandomStringUtils.randomAlphanumeric(10));
        mainPage.setEmailField(RandomStringUtils.randomAlphanumeric(5) + "@test.ru");
        mainPage.setPasswordField(RandomStringUtils.randomAlphanumeric(5));
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается ошибка Некорректный пароль", mainPage.checkPasswordError());
    }
}
