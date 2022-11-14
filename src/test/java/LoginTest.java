import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ui.MainPage;

public class LoginTest extends BaseUITest {
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void authorizationMainPage() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();
        mainPage.clickStellarBurgers();

        mainPage.clickEnterAccountMain();
        mainPage.checkAuthorizationHeader();
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void authorizationFromPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();

        mainPage.clickPersonalAccount();
        mainPage.checkAuthorizationHeader();
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authorizationFromRegistration() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();

        mainPage.clickRegistrationLink();
        mainPage.clickEnterLink();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authorizationFromForgotPassword() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();

        mainPage.clickPersonalAccount();
        mainPage.clickForgotPassword();
        Assert.assertTrue("Не отображается заголовок Восстановление пароля", mainPage.checkForgotPasswordHeader());
        mainPage.clickEnterLink();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();
        Assert.assertTrue("Не отображается кнопка Оформить заказ", mainPage.checkOrderButton());
    }
}
