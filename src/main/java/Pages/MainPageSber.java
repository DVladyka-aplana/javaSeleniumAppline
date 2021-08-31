package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageSber extends BasePage{
    @FindBy(xpath = "//nav[contains(@class,'kitt-top-menu')]")
    WebElement mainMenu;

    public MainPageSber(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void menuSubItem(String itemName){
        mainMenu.findElement(By.xpath("//*[contains(text(),'"+itemName+"')]")).click();
    }

    public void selectMenuItem(String itemName){
        mainMenu.findElement(By.xpath(".//ul[contains(@class,'kitt-top-menu__list_center')]/li/*[contains(text(),'"+itemName+"')]")).click();
    }

}
