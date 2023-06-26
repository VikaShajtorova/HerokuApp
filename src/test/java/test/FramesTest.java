package test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{

    @Test
    public void checkIframeText(){
        framesPage.openFramesPage();
        framesPage.clickIframeButton();
        String text = framesPage.getTextByFrame();

        assertEquals(text,"Your content goes here.","Текст не совпадает");
    }
}
