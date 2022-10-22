package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase{

    @FindBy(xpath = "//a[@class='ico-register']")
    protected WebElement registerLink;

    @FindBy(xpath = "//a[@class='ico-login']")
    protected WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-account']")
    protected WebElement myAccountLink;

    @FindBy(xpath = "//a[@class='ico-logout']")
    protected WebElement logoutLink;


    public HomePage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegisterLink() {
        waitUntilVisibilityOf(registerLink);
        return registerLink;
    }

    public WebElement getLoginLink() {
        waitUntilVisibilityOf(loginLink);
        return loginLink;
    }

    public WebElement getMyAccountLink() {
        waitUntilVisibilityOf(myAccountLink);
        return myAccountLink;
    }

    public WebElement getLogoutLink() {
        waitUntilVisibilityOf(logoutLink);
        return logoutLink;
    }
}
