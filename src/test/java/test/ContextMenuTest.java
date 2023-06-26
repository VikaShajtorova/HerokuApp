package test;

import static org.testng.Assert.*;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    @Test
    public void checkCorrectnessOfAlertText(){
        contextMenuPage.openContextMenuPage();
        contextMenuPage.rightClickOnHotSpot();
        Alert alert = driver.switchTo().alert();

        assertEquals(alert.getText(),"You selected a context menu", "Неверный текст алерта");
        alert.accept();

    }

}
