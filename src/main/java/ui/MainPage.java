package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By personalAccount = By.xpath("//a[@href='/account']/p[@class='AppHeader_header__linkText__3q_va ml-2']");
    private By emailField = By.xpath("//label[.='Email']//following-sibling::*");
    private By passwordField = By.name("Пароль");
    private By registrationLink = By.linkText("Зарегистрироваться");
    private By nameField =
            By.xpath("//label[.='Имя']//following-sibling::*");
    private By registrationButton = By.xpath("//button[.='Зарегистрироваться']");
    private By incorrectPassword = By.xpath("//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    private By registrationHeader = By.xpath("//h2[.='Регистрация']");
    private By authorizationHeader = By.xpath("//h2[.='Вход']");

    private By enterAccountButton = By.xpath("//button[.='Войти в аккаунт']");
    private By enterButton = By.xpath("//button[.='Войти']");
    private By orderButton = By.xpath("//button[.='Оформить заказ']");
    private By enterLink = By.linkText("Войти");
    private By forgotPasswordLink = By.linkText("Восстановить пароль");
    private By forgotPasswordHeader = By.xpath("//h2[.='Восстановление пароля']");
    private By mainHeader = By.className("AppHeader_header__logo__2D0X2");
    private By orderFeed = By.linkText("Лента Заказов");
    private By constructor = By.linkText("Конструктор");
    private By createBurgerHeader = By.xpath("//h1[.='Соберите бургер']");

    public void clickPersonalAccount() {
        webDriver.findElement(personalAccount).click();

    }

    public void clickRegistrationLink() {
        webDriver.findElement(registrationLink).click();
        webDriver.findElement(registrationHeader).isDisplayed();
    }

    public void setNameField(String name) {
        webDriver.findElement(nameField).sendKeys(name);
    }

    public void setEmailField(String email) {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(emailField));
        webDriver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton() {
        webDriver.findElement(registrationButton).click();
    }

    public void waitForLoadHomePage() {
        // подожди 8 секунд, пока появится веб-элемент с нужным текстом
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(createBurgerHeader));
    }

    public boolean checkPasswordError() {
        return webDriver.findElement(incorrectPassword).isDisplayed();
    }

    public boolean checkAuthorizationHeader() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(authorizationHeader));
        return webDriver.findElement(authorizationHeader).isDisplayed();
    }

    public void clickEnterAccountMain() {
        webDriver.findElement(enterAccountButton).click();
    }

    public void clickEnterAccount() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(enterButton));
            webDriver.findElement(enterButton).click();
        }

    public boolean checkOrderButton() {
        new WebDriverWait(webDriver, 8)
                .until(ExpectedConditions.presenceOfElementLocated(orderButton));
        return webDriver.findElement(orderButton).isDisplayed();
    }

    public void clickEnterLink() {
        webDriver.findElement(enterLink).click();
    }

    public void clickForgotPassword() {
        webDriver.findElement(forgotPasswordLink).click();
    }

    public boolean checkForgotPasswordHeader() {
        return webDriver.findElement(forgotPasswordHeader).isDisplayed();
    }

    public void clickConstructor() {
        webDriver.findElement(constructor).click();
    }

    public void clickStellarBurgers() {
        webDriver.findElement(mainHeader).click();
    }

    public boolean checkConstructorPage() {
        return webDriver.findElement(createBurgerHeader).isDisplayed();
    }
}
