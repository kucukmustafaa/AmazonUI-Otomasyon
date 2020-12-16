package org.example;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest {

    private static Logger logger = Logger.getLogger(StepImplementation.class);

    @Step("Anasayfa acildimi kontrol et.")
    public void isHomePageLoad() {
        if (driver.getTitle().equals("Çiçek Sepeti (Çiçekler %30 İndirimli)")) {
            logger.info("Anasayfa basarili bir sekilde yuklendi.");
        } else {
            logger.error("Anasayfa yuklenmedi.");
        }
    }

    @Step("Arama sonucu dogru mu kontrol et.")
    public void checkSearchResult() {
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("o-breadcrumb__title")));
        if (element.getText().equals("bilgisayar")) {
            logger.info("Aranama basarili bir sekilde gerceklesmistir.");
        }else {
            logger.error("arama gerceklesmedi.");
        }
    }

    @Step("Random urun sec.")
    public void selectRandomProduct(){
       List<WebElement> elementList= driver.findElements(By.className("s-main-slot s-result-list s-search-results sg-row"));
       int randNumber=new Random().nextInt();
       elementList.get(randNumber).click();
    }

    @Step("<xpath> xpath 'li elementi <text> degerini iceriyormu kontrol et. ")
    public void isContainsText(String xpath,String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        if (element.getText().contains(text)) {
            logger.info("Element "+text+" degerini iceriyor.");
        }else {
            logger.error("Element "+text+" degerini içermiyor.");
        }
    }
}
