import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseUITest {
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void authorizationMainPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickEnterAccountMain();
        mainPage.checkAuthorizationHeader();
        mainPage.setEmailField("testtest@test.ru");
        mainPage.setPasswordField("123456");
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void authorizationFromPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.checkAuthorizationHeader();
        mainPage.setEmailField("testtest@test.ru");
        mainPage.setPasswordField("123456");
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authorizationFromRegistration() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.clickEnterLink();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField("testtest@test.ru");
        mainPage.setPasswordField("123456");
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authorizationFromForgotPassword() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickForgotPassword();
        Assert.assertTrue("Не отображается заголовок Восстановление пароля", mainPage.checkForgotPasswordHeader());
        mainPage.clickEnterLink();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField("testtest@test.ru");
        mainPage.setPasswordField("123456");
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }
}
