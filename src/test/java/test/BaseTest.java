package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.ContextMenuPage;
import page.DynamicControlsPage;
import page.FileUploadPage;
import page.FramesPage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    String pathToDownload = System.getProperty("user.dir") + "src/test/downloads";
    String nameDownloadFile;
    int wait = 15000;
    boolean fileIsNotReady = true;

    ContextMenuPage contextMenuPage;
    DynamicControlsPage dynamicControlsPage;
    FileUploadPage fileUploadPage;
    FramesPage framesPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", pathToDownload);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--start-maximized");
        options.addArguments("-incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        contextMenuPage = new ContextMenuPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        fileUploadPage = new FileUploadPage(driver);
        framesPage = new FramesPage(driver);
    }

    public void downloader(String fileLocator, String nameDownloadFile) throws IOException, InterruptedException {
        WebElement ourFile = driver.findElement(By.xpath(fileLocator));
        FileUtils.cleanDirectory(new File(pathToDownload));
        File folder = new File(pathToDownload);
        File[] listOfFiles = folder.listFiles();

        ourFile.click();

        while (wait !=0 && fileIsNotReady){
            listOfFiles = folder.listFiles();
            Thread.sleep(100);
            wait-=100;
            if (listOfFiles.length !=0 && listOfFiles[0].getName().equals(nameDownloadFile)){
                fileIsNotReady = false;
            }
        }
        assertEquals(listOfFiles[0].getName(),nameDownloadFile);

    }


        @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
