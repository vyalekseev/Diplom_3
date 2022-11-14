import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.ConstructorPage;
import ui.MainPage;

public class ConstructorTest extends BaseUITest {

    @Test
    @Description("Переход к разделу «Соусы»")
    public void checkSauces() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
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

        constructorPage.clickIngredients();
        constructorPage.clickSauces();
        Assert.assertTrue("Не отображается блок Соусы", constructorPage.checkSaucesHeader());
    }

    @Test
    @Description("Переход к разделу «Булки»")
    public void checkBuns() {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
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

        constructorPage.clickIngredients();
        constructorPage.clickBuns();
        Assert.assertTrue("Не отображается блок Булки", constructorPage.checkBunsHeader());
    }

    @Test
    @Description("Переход к разделу «Начинки»")
    public void checkIngredients()
    {
        ConstructorPage constructorPage = new ConstructorPage(webDriver);
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

        constructorPage.clickIngredients();
        Assert.assertTrue("Не отображается блок Начинки", constructorPage.checkIngredientsHeader());
    }
}
