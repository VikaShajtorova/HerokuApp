package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public static final By HOT_SPOT = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }


    public void open(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }
    public void rightClickOnHotSpot(){
        actions.contextClick(driver.findElement(HOT_SPOT)).build().perform();
    }




}
