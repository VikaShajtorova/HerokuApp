package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.testng.Assert.*;

public class DynamicControlsPage extends BasePage{

    String url = "https://the-internet.herokuapp.com/dynamic_controls";
    public static final By REMOVE_BUTTON = By.xpath("//button[@type='button' and text()='Remove']");
    public static final By ADD_BUTTON = By.xpath("//button[@type='button' and text()='Add']");
    public static final By ENABLE = By.xpath("//button[@autocomplete='off' and text()='Enable']");
    public static final By INPUT = By.xpath("//input[@type='text']");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    public void open(){
        driver.get(url);
    }

    public void clickRemoveButton(){
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void waitingForTextIsAllGone(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
    }

    public void checkIsNoCheckboxByGettingAddButton(){
        boolean isDisplayed = driver.findElement(ADD_BUTTON).isDisplayed();
        assertTrue(isDisplayed, "Нужный элемент не найден");
    }

    public void clickEnableButton(){
        driver.findElement(ENABLE).click();
    }

    public void waitingForTextItIsEnabled(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

    }
    public void inputTextInFieldInput(){
        driver.findElement(INPUT).sendKeys();
    }


}
