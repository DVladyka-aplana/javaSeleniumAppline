package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage extends BasePage{
    @FindBy(xpath = "//div[contains(@class,'kitt-row page-teaser-dict__row')]")
    WebElement travelPage;

    public TravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectButtonCreate(){
        travelPage.findElement(By.xpath(".//a[contains(@data-test-id,'PageTeaserDict_button')]")).click();
    }

}
