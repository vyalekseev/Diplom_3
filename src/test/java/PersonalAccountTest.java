import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.MainPage;
import ui.PersonalAccountPage;

public class PersonalAccountTest extends BaseUITest {

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();

        mainPage.clickPersonalAccount();
        Assert.assertEquals("Не отображается Имя", name, personalAccountPage.getName());
        Assert.assertTrue("Не отображается кнопка Профиль", personalAccountPage.checkProfile());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void goToConstructor() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickRegistrationLink();
        mainPage.setNameField(name);
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickRegistrationButton();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());
        mainPage.setEmailField(email);
        mainPage.setPasswordField(password);
        mainPage.clickEnterAccount();

        mainPage.clickPersonalAccount();
        mainPage.clickConstructor();
        Assert.assertTrue("Отсутствует надпись <Соберите бургер>", mainPage.checkConstructorPage());
        mainPage.clickPersonalAccount();
        mainPage.clickStellarBurgers();
        Assert.assertTrue("Отсутствует надпись <Соберите бургер>", mainPage.checkConstructorPage());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void quitFromAccount() {
        MainPage mainPage = new MainPage(webDriver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
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

        mainPage.clickPersonalAccount();
        Assert.assertEquals("Не отображается Имя", name, personalAccountPage.getName());
        personalAccountPage.clickQuit();
        Assert.assertTrue("Не отображается заголовок Вход", mainPage.checkAuthorizationHeader());

    }
}
