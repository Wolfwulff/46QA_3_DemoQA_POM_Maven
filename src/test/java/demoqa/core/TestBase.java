package demoqa.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();
    //public WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        app.stop();
    }

}
