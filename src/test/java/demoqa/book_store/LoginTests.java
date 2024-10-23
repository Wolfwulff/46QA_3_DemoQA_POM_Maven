package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // user:Wolf
    //pass: Qwertyuiop@1

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getBookStore();
        new SidePage(app.driver).selectLogin();
    }

    @Test(invocationCount = 1)
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("Wolf", "Qwertyuiop@1")
                .clickOnLoginButton()
                .verifyUserName("Wolf");
    }

}
