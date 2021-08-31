package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage extends BasePage{
    @FindBy(xpath = "//div[contains(@class,'product-catalog__carousel_row')]")
    WebElement insurancePage;

    public InsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void selectMenuCarousel(String itemName){
        insurancePage.findElement(By.xpath(".//div[contains(@data-product,'"+itemName+"')]")).click();
    }
}
