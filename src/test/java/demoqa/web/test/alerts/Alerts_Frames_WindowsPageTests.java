package demoqa.web.test.alerts;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Alerts_Frames_WindowsPageTests extends BaseTest {

    @Test(enabled = true)
    public void CheckAllFivePagesLinksAndText() {
        navigateToUrl("alertsWindows");

        String expectedString = "Please select an item from left to start practice.";
        String actualString = alerts_frames_windowsPage.getMainText();
        Assert.assertEquals(actualString, expectedString, "\nWrong text.\n");

        String expectedUrl = "https://demoqa.com/browser-windows";
        alerts_frames_windowsPage.clickBrowserWindows();
        String actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url.\n");

        expectedUrl = "https://demoqa.com/alerts";
        alerts_frames_windowsPage.clickAlerts();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url.\n");

        expectedUrl = "https://demoqa.com/frames";
        alerts_frames_windowsPage.clickFrames();
        actualUrl = alerts_frames_windowsPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url.\n");

        expectedUrl = "https://demoqa.com/nestedframes";
        alerts_frames_windowsPage.clickNestedFrames();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url.\n");

        expectedUrl = "https://demoqa.com/modal-dialogs";
        alerts_frames_windowsPage.clickModalDialogs();
        actualUrl = booksPage.checkUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "\nWrong url.\n");
    }
}