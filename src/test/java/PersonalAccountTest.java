import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonalAccountTest extends BaseUITest {

    @Before
    public void setUp() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickEnterAccountMain();
        mainPage.checkAuthorizationHeader();
        mainPage.setEmailField("testtest@test.ru");
        mainPage.setPasswordField("123456");
        mainPage.clickEnterAccount();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccount() {
        MainPage mainPage = new MainPage(webDriver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        mainPage.clickPersonalAccount();
        String name = personalAccountPage.getName();
        Assert.assertEquals("Василий", name);
        Assert.assertTrue("Не отображается кнопка Профиль", personalAccountPage.checkProfile());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void goToConstructor() {
        MainPage mainPage = new MainPage(webDriver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(webDriver);
        mainPage.clickPersonalAccount();
        mainPage.clickConstructor();
        Assert.assertTrue("Отсутствует надпись <Соберите бургер>", mainPage.checkConstructorPage());
        mainPage.clickPersonalAccount();
        mainPage.clickStellarBurgers();
        Assert.assertTrue("Отсутствует надпись <Соберите бургер>", mainPage.checkConstructorPage());
    }
}
