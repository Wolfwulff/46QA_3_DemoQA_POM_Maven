package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage enterPersonalData(String name, String email, String address) {
        type(userName, name);
        type(userEmail, email);
        type(currentAddress, address);
        return this;
    }

//    @FindBy(id = "permanentAddress")
//    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    public TextBoxPage keyboardEvent() throws AWTException {
//        Actions actions = new Actions(driver);
//        currentAddress.click();
//        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
//        actions.sendKeys(Keys.TAB).perform();
//        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
//        click(submitButton);

        Robot robot = new Robot();
        // Ctrl +A
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // Ctrl +C
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        // Ctrl +V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // Tab
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        // Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        return this;
    }

    @FindBy(css = "p#currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = "p#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyCopyPasteAddress() {
//        String currentAddressText = currentAddress.getAttribute("value");
//        String permanentAddressText = permanentAddress.getAttribute("value");
//        String currentAddress = currentAddressText.replace("Current Address :", "").trim();
//        String permanentAddress = permanentAddressText.replace("Permanent Address :", "").trim();
//        Assert.assertEquals(currentAddress, permanentAddress, "Addresses are not identical!");

        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assert.assertEquals(current[1],permanent[1]);

        return this;
    }
}
