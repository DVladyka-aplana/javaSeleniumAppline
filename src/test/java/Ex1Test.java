/**
 *  Created for java Selenium , Ex: 1
 *  @author Vladyka
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Ex1Test {
    private WebDriver driver;
    private String baseUrl;
    @Before
    public void TestData() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://www.sberbank.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testRun() throws InterruptedException {
        driver.get(baseUrl);
        if(!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()){
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
        driver.findElement(By.xpath("//ul[contains(@class,'kitt-top-menu__list_center')]/li/*[contains(text(),'Страхование')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Все страховые программы')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'product-catalog__carousel_row')]/div[contains(@data-product,'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]"))));
        assertEquals("Страхование путешественников",driver.findElement(By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]")).getText());
        if(!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()){
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(@data-test-id,'PageTeaserDict_button')]")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]"))));
        assertEquals("Страхование путешественников",driver.findElement(By.xpath("//h2[contains(text(),'Страхование путешественников')]")).getText());
        driver.findElement(By.xpath("//div[contains(@class,'form-control__select')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Шенген и страны Совета Европы, кроме РФ')]")).click();
        driver.findElement(By.xpath("//h3[contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Оформить')]")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//legend[contains(text(),'Застрахованные')]"))));
        fillField(By.xpath("//input[contains(@placeholder,'Surname')]"), "Petrov");
        fillField(By.xpath("//input[contains(@placeholder,'Name')]"), "Ivan");
        fillField(By.xpath("//input[contains(@placeholder,'дд.мм.гггг')]"), "10.01.1980");

        fillField(By.id("person_firstName"), "Олег");
        fillField(By.id("person_lastName"), "Иванов");
        fillField(By.id("person_middleName"), "Викторович");
        fillField(By.id("person_birthDate"), "11.11.1991");

        if(!driver.findElements(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid active')][contains(text(),'Женский')]")).isEmpty()){
            driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Мужской')]")).click();
        }

        fillField(By.id("passportSeries"), "1111");
        fillField(By.id("passportNumber"), "111111");
        fillField(By.id("documentDate"), "11.11.2011");
        fillField(By.id("documentIssue"), "МФЦ МО РФ ФБР");

        assertEquals("МФЦ МО РФ ФБР", driver.findElement(By.id("documentIssue")).getAttribute("value"));
        assertEquals("11.11.2011", driver.findElement(By.id("documentDate")).getAttribute("value"));
        assertEquals("111111", driver.findElement(By.id("passportNumber")).getAttribute("value"));
        assertEquals("1111", driver.findElement(By.id("passportSeries")).getAttribute("value"));
        assertEquals("11.11.1991", driver.findElement(By.id("person_birthDate")).getAttribute("value"));
        assertEquals("Викторович", driver.findElement(By.id("person_middleName")).getAttribute("value"));
        assertEquals("Иванов", driver.findElement(By.id("person_lastName")).getAttribute("value"));
        assertEquals("Олег", driver.findElement(By.id("person_firstName")).getAttribute("value"));
        assertEquals("10.01.1980", driver.findElement(By.xpath("//input[contains(@placeholder,'дд.мм.гггг')]")).getAttribute("value"));
        assertEquals("Ivan", driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]")).getAttribute("value"));
        assertEquals("Petrov", driver.findElement(By.xpath("//input[contains(@placeholder,'Surname')]")).getAttribute("value"));

        driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).click();

        assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getAttribute("innerText"));
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Мобильный телефон')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Электронная почта')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        assertEquals("Поле не заполнено.", driver.findElement(By.xpath("//form-control-label[contains(@title,'Повтор электронной почты')]//span[contains(@class,'message')]")).getAttribute("innerText"));

    }

    @After
    public void afterTest(){
        driver.quit();
    }

    private void fillField(By locator, String value) throws InterruptedException {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        Thread.sleep(1000);
        driver.findElement(locator).sendKeys(value);
    }
}
