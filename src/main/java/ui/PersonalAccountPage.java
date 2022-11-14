package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class PersonalAccountPage extends BasePage {
    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By name = By.name("Name");
    private By profile = By.linkText("Профиль");
    private By quit = By.xpath("//button[@type='button' and text()='Выход']");

    public String getName() {
        return webDriver.findElement(name).getAttribute("value");
    }

    public boolean checkProfile() {
        return webDriver.findElement(profile).isDisplayed();
    }

    public void clickQuit() {
        webDriver.findElement(quit).click();
    }
}
