package test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    @Test
    public void checkFileDownload(){
        fileUploadPage.openFileUploadPage();
        fileUploadPage.downloadFile();
        String text = fileUploadPage.getTextFileUploaded();

        assertEquals(text,"File Uploaded!","Файл не загрузился");
    }

}
