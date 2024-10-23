package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class TextBoxTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectTextBox().hideAds();
    }

    @Test
    public void keyboardEventTest() throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData("Name", "email@gmail.com","Germany, Berlin")
                .keyboardEvent()
                .verifyCopyPasteAddress()
        ;
    }


    @Test(dataProvider = "addNewUserFormFromCSVFile", dataProviderClass = DataProviders.class)
    public void keyboardEventDataProviderTest(String name, String email, String address) throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData(name, email,address)
                .keyboardEvent()
                .verifyCopyPasteAddress()
        ;
    }
}
