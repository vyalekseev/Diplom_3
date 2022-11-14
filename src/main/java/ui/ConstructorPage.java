package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.BasePage;

public class ConstructorPage extends BasePage {
    public ConstructorPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By buns = By.xpath("//span[@class='text text_type_main-default' and text()='Булки']");
    private By sauces = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']");
    private By ingredients = By.xpath("//span[@class='text text_type_main-default' and text()='Начинки']");
    private By bunsHeader = By.xpath("//h2[.='Булки']");

    private By saucesHeader = By.xpath("//h2[.='Соусы']");

    private By ingredientsHeader = By.xpath("//h2[.='Начинки']");

    public void clickBuns() {
        webDriver.findElement(buns).click();
    }
    public void clickSauces() {
        webDriver.findElement(sauces).click();
    }
    public void clickIngredients() {
        webDriver.findElement(ingredients).click();
    }

    public boolean checkBunsHeader() {
        return webDriver.findElement(bunsHeader).isDisplayed();
    }

    public boolean checkSaucesHeader() {
        return webDriver.findElement(saucesHeader).isDisplayed();
    }

    public boolean checkIngredientsHeader() {
        return webDriver.findElement(ingredientsHeader).isDisplayed();
    }
}
