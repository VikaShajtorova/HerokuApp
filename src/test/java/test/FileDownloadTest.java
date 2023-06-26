package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownloadTest extends BaseTest{
    @Test
    public void fileDownload(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/PICTURE.PNG']")).click();
        File file = new File(pathToDownload);


    }
}
