package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends TestBase{

   private Faker faker = new Faker();
   private String firstName = faker.name().firstName();
   private String lastName = faker.name().lastName();
   private String email = faker.internet().emailAddress();
   private String day = String.valueOf(faker.number().numberBetween(1,31));
   private String month = String.valueOf(faker.number().numberBetween(1,12));
   private String year = String.valueOf(faker.number().numberBetween(1990,2015));
   private String company = faker.company().name();
   private String password = faker.internet().password(7,10,true,true);
   private RegisterPage registerObj;
   private HomePage homeObj;
   private SoftAssert softAssert;

    @Test(description = "User login with valid credentials")
    public void userLoginWithCredentials(){

        homeObj = new HomePage(driver);
        homeObj.clickOnElement(homeObj.getRegisterLink());

        registerObj = new RegisterPage(driver);
        registerObj.loginWithAllFields(firstName,lastName,email,day,month,year,company,password,password);
        softAssert = new SoftAssert();
        softAssert.assertTrue(registerObj.getSuccessRegistrationMessage().isDisplayed());
        registerObj.clickOnElement(registerObj.getContinueBtn());

        homeObj = new HomePage(driver);
        softAssert.assertTrue(homeObj.getMyAccountLink().isDisplayed());
        softAssert.assertTrue(homeObj.getLogoutLink().isDisplayed());
        homeObj.clickOnElement(homeObj.getLogoutLink());
        softAssert.assertAll();

    }
}
