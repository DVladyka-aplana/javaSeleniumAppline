package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BasePage {
    WebDriver driver;

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void fillField(WebElement element, String value) throws InterruptedException {
        element.click();
        element.clear();
        Thread.sleep(1000);
        element.sendKeys(value);
    }

    public void checkCookieButton() {
        if (!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()) {
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
    }
    public void checkHead(By by, int seconds, String exp){
        Wait<WebDriver> wait = new WebDriverWait(driver, seconds, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        assertEquals(exp,driver.findElement(by).getText());
    }
}
