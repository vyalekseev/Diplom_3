import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    public PersonalAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By name = By.name("Name");
    private By profile = By.linkText("Профиль");

    public String getName() {
        return webDriver.findElement(name).getAttribute("value");
    }
    public boolean checkProfile() {
        return webDriver.findElement(profile).isDisplayed();
    }
}
