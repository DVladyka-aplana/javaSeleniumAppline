package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class SetValuesTravelInsurancePage extends BasePage{
    @FindBy(xpath = "//input[contains(@placeholder,'Surname')]")
    WebElement lastNameTo;

    @FindBy(xpath = "//input[contains(@placeholder,'Name')]")
    WebElement firstNameTo;

    @FindBy(xpath = "//input[contains(@placeholder,'дд.мм.гггг')]")
    WebElement dateBirthdayTo;

    @FindBy(id = "person_firstName")
    WebElement firstNameFrom;

    @FindBy(id = "person_lastName")
    WebElement lastNameFrom;

    @FindBy(id = "person_middleName")
    WebElement middleNameFrom;

    @FindBy(id = "person_birthDate")
    WebElement birthdayFrom;

    @FindBy(id = "passportSeries")
    WebElement passportSeries;
    @FindBy(id = "passportNumber")
    WebElement passportNumber;
    @FindBy(id = "documentDate")
    WebElement documentDate;
    @FindBy(id = "documentIssue")
    WebElement documentIssue;

    @FindBy(xpath = "//button[contains(text(),'Продолжить')]")
    public WebElement nextButton;
    @FindBy(xpath = "//button[contains(text(),'Оформить')]")
    public WebElement arrangeButton;



    public SetValuesTravelInsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setRegion (String itemName){
        driver.findElement(By.xpath("//div[contains(@class,'form-control__select')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'"+itemName+"')]")).click();
    }

    public void setSum (String itemName){
        driver.findElement(By.xpath("//h3[contains(text(),'"+itemName+"')]")).click();
    }

    public void clickButton(String buttonName){
        switch (buttonName){
            case "Продолжить":
                nextButton.click();
                break;
            case "Оформить":
                arrangeButton.click();
                break;
            default:
                throw new AssertionError("Кнопка '" + buttonName + "' не найдена на странице");
        }
    }

    public void fillField(String fieldName, String value) throws InterruptedException {
        switch (fieldName) {
            case "ФамилияTo":
                fillField(lastNameTo, value);
                break;
            case "ИмяTo":
                fillField(firstNameTo, value);
                break;
            case "ДрTo":
                fillField(dateBirthdayTo, value);
                break;
            case "ФамилияFrom":
                fillField(lastNameFrom, value);
                break;
            case "ИмяFrom":
                fillField(firstNameFrom, value);
                break;
            case "ОтчествоFrom":
                fillField(middleNameFrom, value);
                break;
            case "ДрFrom":
                fillField(birthdayFrom, value);
                break;
            case "Паспорт серия":
                fillField(passportSeries, value);
                break;
            case "Паспорт номер":
                fillField(passportNumber, value);
                break;
            case "Паспорт дата":
                fillField(documentDate, value);
                break;
            case "Паспорт выдан":
                fillField(documentIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

        public void getFillField (String waitVal, String cellName) throws InterruptedException {
            switch (cellName) {
                case "ФамилияTo":
                    assertEquals(waitVal, lastNameTo.getAttribute("value"));
                    break;
                case "ИмяTo":
                    assertEquals(waitVal, firstNameTo.getAttribute("value"));
                    break;
                case "ДрTo":
                    assertEquals(waitVal, dateBirthdayTo.getAttribute("value"));
                    break;
                case "ФамилияFrom":
                    assertEquals(waitVal, lastNameFrom.getAttribute("value"));
                    break;
                case "ИмяFrom":
                    assertEquals(waitVal, firstNameFrom.getAttribute("value"));
                    break;
                case "ОтчествоFrom":
                    assertEquals(waitVal, middleNameFrom.getAttribute("value"));
                    break;
                case "ДрFrom":
                    assertEquals(waitVal, birthdayFrom.getAttribute("value"));
                    break;
                case "Паспорт серия":
                    assertEquals(waitVal, passportSeries.getAttribute("value"));
                    break;
                case "Паспорт номер":
                    assertEquals(waitVal, passportNumber.getAttribute("value"));
                    break;
                case "Паспорт дата":
                    assertEquals(waitVal, documentDate.getAttribute("value"));
                    break;
                case "Паспорт выдан":
                    assertEquals(waitVal, documentIssue.getAttribute("value"));
                    break;
                default:
                    throw new AssertionError("Поле не объявлено на странице");

            }
        }

        public void checkErrorMessage(String waitMessage){
            assertEquals(waitMessage, driver.findElement(By.xpath("//div[contains(@class,'alert-form alert-form-error')]")).getAttribute("innerText"));
        }

        public void checkCellErrorMessage(String waitMessage, String cellName){
            assertEquals(waitMessage, driver.findElement(By.xpath("//form-control-label[contains(@title,'"+cellName+"')]//span[contains(@class,'message')]")).getAttribute("innerText"));
        }
        public void checkFemale (String feMale){
            switch (feMale) {
                case "Мужской":
                    if (!driver.findElements(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid active')][contains(text(),'Женский')]")).isEmpty()) {
                        driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Мужской')]")).click();
                    }
                    break;
                case "Женский":
                    if (!driver.findElements(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid active')][contains(text(),'Мужской')]")).isEmpty()) {
                        driver.findElement(By.xpath("//label[contains(@class,'btn ng-untouched ng-pristine ng-valid')][contains(text(),'Женский')]")).click();
                    }
                    break;
            }
        }
    }