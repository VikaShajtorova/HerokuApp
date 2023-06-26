package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }
    String url = "https://the-internet.herokuapp.com/upload";
    public static final By SELECT_FILE_BUTTON = By.id("file-upload");
    public static final By UPLOAD_BUTTON = By.id("file-submit");
    String fileUploaded = "//h3[text()='File Uploaded!']";

    public void openFileUploadPage(){
        driver.get(url);
    }
    public void clickSelectFileButton(){
        driver.findElement(SELECT_FILE_BUTTON).click();
    }
    public void clickUploadButton(){
        driver.findElement(UPLOAD_BUTTON).click();
    }
    public void downloadFile(){
        File file = new File("src/test/resources/sznaucer-miniaturowy-czarno-srebrny-32984.jpeg");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        driver.findElement(UPLOAD_BUTTON).click();
    }
    public String getTextFileUploaded(){
        return driver.findElement(By.xpath(fileUploaded)).getText();
    }
}
