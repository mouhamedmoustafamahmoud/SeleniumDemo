package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends PageBase{

    @FindBy(id = "gender-male")
    protected WebElement maleGenderRadioBtn;

    @FindBy(id = "gender-female")
    protected WebElement femaleGenderRadioBtn;

    @FindBy(id = "FirstName")
    protected WebElement firstNameTxtField;

    @FindBy(id = "LastName")
    protected WebElement lastNameTxtField;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    protected WebElement dayDDM;

    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    protected WebElement monthDDM;

    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    protected WebElement yearDDM;

    @FindBy(id = "Email")
    protected WebElement emailTxtField;

    @FindBy(id = "Company")
    protected WebElement companyNameTxtField;

    @FindBy(id = "Newsletter")
    protected WebElement newsletterCheckBox;

    @FindBy(id = "Password")
    protected WebElement passwordTxtField;

    @FindBy(id = "ConfirmPassword")
    protected WebElement confirmPasswordTxtField;

    @FindBy(id = "register-button")
    protected WebElement registerBtn;

    @FindBy(xpath = "//div[@class='result']")
    protected WebElement successRegistrationMessage;

    @FindBy(xpath = "//a[@class='button-1 register-continue-button']")
    protected WebElement continueBtn;


    public RegisterPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithAllFields(String firstName, String lastName, String email, String day,
                                   String month, String year, String company, String password, String confirmPassword){

        // Enter Personal Details.
        clickOnElement(maleGenderRadioBtn);
        enterDataToField(firstNameTxtField, firstName);
        enterDataToField(lastNameTxtField, lastName);
        selectFromDDM(dayDDM, day);
        selectFromDDM(monthDDM, month);
        selectFromDDM(yearDDM, year);
        enterDataToField(emailTxtField, email);

        // Enter Company Details.
        enterDataToField(companyNameTxtField, company);

        // Deselect Newsletter Option.
        clickOnElement(newsletterCheckBox);

        // Enter the password and confirm it.
        enterDataToField(passwordTxtField, password);
        enterDataToField(confirmPasswordTxtField, confirmPassword);

        // Click on Register Button
        clickOnElement(registerBtn);

    }

    public WebElement getSuccessRegistrationMessage() {
        waitUntilVisibilityOf(successRegistrationMessage);
        return successRegistrationMessage;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }
}
