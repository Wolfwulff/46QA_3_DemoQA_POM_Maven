package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String text) {
        assert userNameValue.getText().contains(text);
        return this;
    }
}
