package part3.comdemoqa.tests.widgets;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3.comdemoqa.base.BaseTest;

public class ProgressBarPageTests extends BaseTest {

    @Test(enabled = false)
    public void ClickStartButtonCheckEnValue() throws InterruptedException {
        navigateToUrl("progress-bar");

        progressBarPage.clickStartButton();

        String actualText = progressBarPage.getValueProgressBar();
        String expectedText = "100";


        Assert.assertEquals(actualText, expectedText, "Wrong time value");
    }
}
