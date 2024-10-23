package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoCompletePage extends BasePage {

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;

    public AutoCompletePage autoComplete(String letter) {
        autoCompleteMultipleInput.sendKeys(letter);
        autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement autoCompleteMultipleContainer;

    public AutoCompletePage verifyAutoComplete(String color) {
        shouldHaveText(autoCompleteMultipleContainer, color, 5000);
        return this;
    }

    public AutoCompletePage autoCompleteArray(String[] letters) {
        for (String letter : letters) {
            autoCompleteMultipleInput.sendKeys(letter);
            autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);
        }
        return this;
    }

    public AutoCompletePage verifyAutoCompleteArray(String[] colors) {
        for (String color : colors) {
            shouldHaveText(autoCompleteMultipleContainer, color, 5000);
        }
        return this;
    }
}
