package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String name, String surName, String email, String number) {
        //firstName.sendKeys(name);
        type(firstName, name);
        type(lastName, surName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }

    //    //label[contains(text(),'Other')]
    //    //label[contains(text(),'Male')]
    //    //label[contains(text(),'Female')]
    public PracticeFormPage selectGender(String gender) {
        try {
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
            click(genderLocator);
        } catch (NoSuchElementException e) {
            System.out.println("Gender element not found: [" + gender + "]");
            throw new NoSuchElementException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error selecting gender: [" + gender + "]");
            throw new RuntimeException(e);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;

//    public PracticeFormPage chooseDate(String day, String month, String year) {
//        click(dateOfBirthInput);
//        new Select(monthSelect).selectByVisibleText(month);
//        new Select(yearSelect).selectByVisibleText(year);
////div[@class='react-datepicker__week']//div[.='4']
//        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
//        return this;
//    }

    //  HomeWork
//    public PracticeFormPage chooseDateAsString(String date) {
//        click(dateOfBirthInput);
//        String[] dateParts = date.split(" ");
//        String day = dateParts[0];
//        String month = dateParts[1];
//        String year = dateParts[2];
//
//        wait.until(ExpectedConditions.elementToBeClickable(monthSelect));
//        new Select(monthSelect).selectByVisibleText(month);
//        wait.until(ExpectedConditions.elementToBeClickable(yearSelect));
//        new Select(yearSelect).selectByVisibleText(year);
//        if (day.startsWith("0")) {
//            day = day.substring(1);
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")));
//        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
//
//        return this;
//    }

    public PracticeFormPage chooseDateAsString(String date) {
        click(dateOfBirthInput);
        String os = System.getProperty("os.name");
        //type(dateOfBirthInput,date);
        if(os.contains("Mac")){
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(date);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }



    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        for (String subject : subjects) {
            if (subject != null) {
                type(subjectsInput, subject);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    //label[.='Reading']
    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (String hobby : hobbies) {
            try {
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            } catch (Exception e) {
                System.out.println("Error selecting hobbies: [" + hobby + "]");
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String imgPath) {
        uploadPicture.sendKeys(imgPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        type(currentAddress, address);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage enterState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage enterCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submitForm() {
        click(submit);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement registrationModal;

    public PracticeFormPage verifySuccessRegistration(String text) {
        shouldHaveText(registrationModal, text, 5000);
        return this;

    }
}
