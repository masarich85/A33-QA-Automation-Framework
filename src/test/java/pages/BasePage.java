package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void performDoubleClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(locator).perform();
    }

}
