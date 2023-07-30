package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import javax.swing.*;
public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement createAccount= driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions=new Actions(driver);
        actions.click(createAccount).perform();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.sendKeys("Canan").sendKeys(Keys.TAB).
                sendKeys("Soylu").sendKeys(Keys.TAB).
                sendKeys("ccs@gmail.com").sendKeys(Keys.TAB).sendKeys("ccs@gmail.com").sendKeys(Keys.TAB).
                sendKeys("1ccs@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"))).perform();
    }
}






