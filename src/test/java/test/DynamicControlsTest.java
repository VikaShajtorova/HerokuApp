package test;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    @Test
    public void checkIfThereIsNoCheckboxOnPage() {
        dynamicControlsPage.openDynamicControlsPage();
        dynamicControlsPage.clickRemoveButton();
        String text = dynamicControlsPage.waitingMessageItIsGone();

        assertEquals(text, "It's gone!", "Текст не совпадает или отсутствует");
        assertTrue(dynamicControlsPage.checkPresenceOfAddButtonOnPage(), "Чекбокс на странице");
    }

    @Test
    public void checkThatInputIsDisabled() {
        dynamicControlsPage.openDynamicControlsPage();
        dynamicControlsPage.findInputDisabled();
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.waitingForTextItIsEnabled();
        dynamicControlsPage.clickDisabledButton();
        String text = dynamicControlsPage.waitingMessageItIsDisabled();

        assertEquals(text, "It's disabled!", "Input enabled");
        assertTrue(dynamicControlsPage.checkPresenceOfEnableButtonOnPage(), "Input enabled");
    }

    @Test
    public void checkThatInputIsEnable() {
        dynamicControlsPage.openDynamicControlsPage();
        dynamicControlsPage.clickEnableButton();
        String text = dynamicControlsPage.waitingForTextItIsEnabled();
        dynamicControlsPage.inputTextInFieldInput();

        assertEquals(text, "It's enabled!", "Input disabled");
        assertTrue(dynamicControlsPage.checkPresenceOfDisableButtonOnPage(), "Input disabled");
    }

}
