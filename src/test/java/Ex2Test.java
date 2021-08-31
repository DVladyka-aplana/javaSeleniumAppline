/**
 *  Created for java Selenium , Ex: 2
 *  @author Vladyka
 */

import Pages.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class Ex2Test extends BaseTest{

    @Test
    public void testRun() throws InterruptedException {
        driver.get(baseUrl);

        //Панель кнопок на главной странице
        MainPageSber mainPage = new MainPageSber(driver);
        mainPage.checkCookieButton();
        mainPage.selectMenuItem("Страхование");
        mainPage.menuSubItem("Все страховые программы");

        //Форма "Страхование"
        InsurancePage insurancePage = new InsurancePage(driver);
        insurancePage.selectMenuCarousel("Страхование путешественников");

        //Форма "Страхование путешественников"
        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        travelInsurancePage.checkHead((By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]")),10,"Страхование путешественников");
        travelInsurancePage.checkCookieButton();
        travelInsurancePage.selectButtonCreate();

        //Форма ввода для "Страхование путешественников"
        SetValuesTravelInsurancePage setValPage = new SetValuesTravelInsurancePage(driver);
        setValPage.checkHead((By.xpath("//h2[contains(text(),'Страхование путешественников')]")),10,"Страхование путешественников");
        setValPage.setRegion("Шенген и страны Совета Европы, кроме РФ");
        setValPage.setSum("Минимальная");

        setValPage.clickButton("Оформить");

        setValPage.fillField("ФамилияTo", "Ivanov");
        setValPage.fillField("ИмяTo", "Ivan");
        setValPage.fillField("ДрTo", "11.11.1991");

        setValPage.fillField("ФамилияFrom", "Петров");
        setValPage.fillField("ИмяFrom", "Петр");
        setValPage.fillField("ОтчествоFrom", "Петрович");
        setValPage.fillField("ДрFrom", "12.12.1990");
        setValPage.checkFemale("Мужской");

        setValPage.fillField("Паспорт серия", "1111");
        setValPage.fillField("Паспорт номер", "1111111");
        setValPage.fillField("Паспорт дата", "12.12.2011");
        setValPage.fillField("Паспорт выдан", "МФЦ");

        setValPage.getFillField("Ivanov","ФамилияTo");
        setValPage.getFillField("Ivan","ИмяTo");
        setValPage.getFillField("11.11.1991","ДрTo");
        setValPage.getFillField("Петров","ФамилияFrom");
        setValPage.getFillField("Петр","ИмяFrom");
        setValPage.getFillField("Петрович","ОтчествоFrom");
        setValPage.getFillField("12.12.1990","ДрFrom");
        setValPage.getFillField("1111","Паспорт серия");
        setValPage.getFillField("111111","Паспорт номер");
        setValPage.getFillField("12.12.2011","Паспорт дата");
        setValPage.getFillField("МФЦ","Паспорт выдан");

        setValPage.clickButton("Продолжить");

        setValPage.checkErrorMessage("При заполнении данных произошла ошибка");
        setValPage.checkCellErrorMessage("Поле не заполнено.","Мобильный телефон");
        setValPage.checkCellErrorMessage("Поле не заполнено.","Электронная почта");
        setValPage.checkCellErrorMessage("Поле не заполнено.","Повтор электронной почты");
    }
}