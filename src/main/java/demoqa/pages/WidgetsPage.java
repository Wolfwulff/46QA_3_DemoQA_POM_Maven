package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

import static org.openqa.selenium.devtools.v129.debugger.Debugger.pause;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    //* Old Style Select Menu
    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        shouldHaveText(oldSelectMenu, color, 5000);
        return this;
    }

    //* MultiSelectMenu
    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    @FindBy(css = ".css-12jo7m5")
    List<WebElement> selectedColorsElements;

    public boolean areColorsSelected(String[] colors) {
        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());
        }
        for (String color : colors) {
            pause();
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }

    public WidgetsPage verifyColorSelected(String[] colorsSelect) {
        assertTrue(new WidgetsPage(driver).areColorsSelected(colorsSelect));
        return this;
    }


    // Выбор одного автомобиля
    @FindBy(id = "cars")
    WebElement standardSelectMenu;

    public WidgetsPage selectSingleCar(String car) {
        Select select = new Select(standardSelectMenu);
        select.selectByVisibleText(car);

        WebElement selectedOption = select.getFirstSelectedOption();
        assertEquals(car, selectedOption.getText(), "Автомобиль не выбран: " + car);
        return this;
    }

    // Выбор несколько авто
    @FindBy(id = "cars")
    WebElement standardMultiSelectMenu;

    public WidgetsPage selectMultipleCars(String[] cars) {
        Select select = new Select(standardMultiSelectMenu);

        for (String car : cars) {
            select.selectByVisibleText(car);
        }
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedCarsText = new ArrayList<>();
        for (WebElement option : selectedOptions) {
            selectedCarsText.add(option.getText());
        }
        for (String car : cars) {
            assertTrue(selectedCarsText.contains(car), "Автомобиль не выбран: " + car);
        }
        return this;
    }

    //********************************* 26 урок **************************

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        //System.out.println(select.getOptions().get(index).getText());
        System.out.println(selectedText);
        return this;
    }

    public WidgetsPage verifyByIndex(int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;
        // Проходим по всем выбранным элементам списка
        for (WebElement element : selectedOptions) {
            if (element.getText().equals(selectedText)) {
                textFound = true;
                break;
            }
        }
        System.out.println(selectedText);
        Assert.assertTrue(textFound);
        // assert textFound;
        return this;
    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for (String element : car) {
                select.selectByVisibleText(element);
            }
        }
        return this;
    }

    public WidgetsPage verifyMultiSelectByCars(String[] expected) {
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = new ArrayList<>();

        for (WebElement option : selectedOptions) {
            selectedText.add(option.getText());
        }
        List<String> expectedText = Arrays.asList(expected);
        assert new HashSet<>(selectedText).containsAll(expectedText);
        return this;
    }
}
