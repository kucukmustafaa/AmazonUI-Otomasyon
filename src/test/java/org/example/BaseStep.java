package org.example;
import com.thoughtworks.gauge.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;


public class BaseStep extends BaseTest{
    private static Logger logger= Logger.getLogger(StepImplementation.class);

    public static String getTitle(){
        return driver.getTitle();
    }
    public static String getText(WebElement element){
        return element.getText();
    }

    @Step("click with id <id>")
    public void clickWithId(String id){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        try {
            element.click();
            logger.info(id+ " li elemente tiklandi.");
        }catch (Exception e){
            logger.error("elemente tiklanamadi." );
        }
    }

    @Step("click with classname <classname>")
    public void clickWithClassName(String classname){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classname)));
        try {
            element.click();
            logger.info(classname+ " li elemente tiklandi.");
        }catch (Exception e){
            logger.error("elemente tiklanamadi." );
        }
    }

    @Step("click with cssSelector <cssSelector>")
    public void clickWithCssSelectore(String cssSelector){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        try {
            element.click();
            logger.info(cssSelector+ " li elemente tiklandi.");
        }catch (Exception e){
            logger.error(cssSelector+" elementine tiklanamadi.");
        }
    }

    @Step("click with xpath <xpath>")
    public void clickWithXpath(String xpath){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        try {
            element.click();
            logger.info(xpath+ " li elemente tiklandi.");
        }catch (Exception e){
            logger.error(xpath+" elementine tiklanamadi.");
        }
    }

    @Step("focus click with id <id>")
    public void focusClickWithId(String id){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        try {
            new Actions(driver).moveToElement(element).perform();
            logger.info(id+ " li elemente focus ile tiklandi.");
        }catch (Exception e){
            logger.error("elemente focus ile tiklanamadi." );
        }
    }




    @Step("focus click with classname <classname>")
    public void focusClickWithClassName(String classname){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(classname)));
        try {
            new Actions(driver).moveToElement(element).perform();
            logger.info(classname+ " li elemente focus ile tiklandi.");
        }catch (Exception e){
            logger.error("elemente focus ile tiklanamadi." );
        }
    }

    @Step("focus click with cssSelector <cssSelector>")
    public void focusClickWithCssSelectore(String cssSelector){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        try {
            new Actions(driver).moveToElement(element).perform();
            logger.info(cssSelector+ " li elemente focus ile tiklandi.");
        }catch (Exception e){
            logger.error(cssSelector+" elementine focus ile tiklanamadi.");
        }
    }

    @Step("focus click with xpath <xpath>")
    public void focusClickWithXpath(String xpath){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        try {
            new Actions(driver).moveToElement(element).perform();
            logger.info(xpath+ " li elemente focus ile tiklandi.");
        }catch (Exception e){
            logger.error(xpath+" elementine focus ile tiklanamadi.");
        }
    }


    @Step("<xpath> xpath'li elementine <text> degerini yaz.")
    public void writeTextToElementWithXpath(String xpath,String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        try {
            element.sendKeys(text);
            logger.info(xpath+ " elementine "+text+" degeri basarili bir sekilde yazildi.");
        }catch (Exception e){
            logger.error(xpath+ " elementine "+text+" degeri yazilmadi.");
        }
    }


    @Step("<cssSelector> cssSelector'lu elementine <text> degerini yaz.")
    public void writeTextToElementWithCssSelector(String cssSelector,String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        try {
            element.sendKeys(text);
            logger.info(cssSelector+ " elementine "+text+" degeri basarili bir sekilde yazildi.");
        }catch (Exception e){
            logger.error(cssSelector+ " elementine "+text+" degeri yazilmadi.");
        }
    }

    @Step("<id> id'li elementine <text> degerini yaz.")
    public void writeTextToElementWithId(String id,String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        try {
            element.sendKeys(text);
            logger.info(id+ " elementine "+text+" degeri basarili bir sekilde yazildi.");
        }catch (Exception e){
            logger.error(id+ " elementine "+text+" degeri yazilmadi.");
        }
    }

    @Step("<className> className'li elementine <text> degerini yaz.")
    public void writeTextToElementWithClassname(String className,String text){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        try {
            element.sendKeys(text);
            logger.info(className+ " elementine "+text+" degeri basarili bir sekilde yazildi.");
        }catch (Exception e){
            logger.error(className+ " elementine "+text+" degeri yazilmadi.");
        }
    }

    @Step("<milliseconds> milisaniye bekle.")
    public void waitSeconds(int milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
