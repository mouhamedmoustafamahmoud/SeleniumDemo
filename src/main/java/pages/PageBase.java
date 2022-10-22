package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected Select select;

    protected void waitUntilVisibilityOf(WebElement webElement){
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void enterDataToField(WebElement webElement, String data){
        waitUntilVisibilityOf(webElement);
        webElement.clear();
        webElement.sendKeys(data);
    }

    public void selectFromDDM(WebElement webElement, String data){
        waitUntilVisibilityOf(webElement);
        select = new Select(webElement);
        select.selectByValue(data);
    }

    public void clickOnElement(WebElement webElement){
        waitUntilVisibilityOf(webElement);
        webElement.click();
    }

}
