package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.ButtonsPage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectButtons().hideAds();
    }

    @Test
    public void doubleClickButtonsTest() {
        new ButtonsPage(app.driver)
                .doubleClick()
                .verifyDoubleClickMessage("You have done a double click");
    }

    @Test
    public void rightClickButtonTest() throws InterruptedException {
        new ButtonsPage(app.driver)
                .rightClickButton()
                .verifyRightClickMessage("You have done a right click");
    }

    @Test(invocationCount = 1)
    public void clickDynamicButtonTest() {
        new ButtonsPage(app.driver)
                .dynamicclickButton()
                .verifyDynamicClickMessage("You have done a dynamic click");
    }

}
