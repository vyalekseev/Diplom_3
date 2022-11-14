import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ui.MainPage;

public class RegistrationTest extends BaseUITest {

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationNewUser() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается надпись Вход", mainPage.checkAuthorizationHeader());
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void registrationIncorrectPassword() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField("12345");
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается ошибка Некорректный пароль", mainPage.checkPasswordError());
    }
}
