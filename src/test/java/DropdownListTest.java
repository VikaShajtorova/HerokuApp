import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DropdownListTest extends BaseTest {

    @Test
    public void checkSelectionOfItemInDropdownList() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownList);
        List options = select.getOptions();

        assertEquals(options.size(),3);

        select.selectByIndex(1);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 1");

        select.selectByIndex(2);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }
}
