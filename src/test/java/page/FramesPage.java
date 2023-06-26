package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage{
    String url = "https://the-internet.herokuapp.com/frames";
    public static final By I_FRAME_BUTTON = By.xpath("//a[text()='iFrame']");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void openFramesPage(){
        driver.get(url);
    }
    public void clickIframeButton(){
        driver.findElement(I_FRAME_BUTTON).click();
    }

    public String getTextByFrame() {
        WebDriver frame = driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        return frame.findElement(By.xpath("//p[text()='Your content goes here.']")).getText();
    }
}
