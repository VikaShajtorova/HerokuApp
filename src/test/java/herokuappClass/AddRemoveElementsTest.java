package herokuappClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {
    @Test
    public void addRemoveElements(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.cssSelector("[onclick='addElement()']"));
        addElementButton.click();
        addElementButton.click();


        List<WebElement> deleteButtonsList = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtonsList.size(),2,"На странице не 2 элемента");

        deleteButtonsList.get(0).click();
        deleteButtonsList = driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        assertEquals(deleteButtonsList.size(),1,"На странице не 2 элемента");


    }


}
