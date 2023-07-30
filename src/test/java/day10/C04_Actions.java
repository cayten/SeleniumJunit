package day10;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import java.util.ArrayList;
import java.util.List;
public class C04_Actions extends TestBaseBeforeAfter {
    //https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //Cizili alan bölümün uzerinde sag click yapalim
    //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //Tamam diyerek alert’i kapatalim
    //Elemental Selenium linkine tiklayalim
    //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Cizili alan bölümün uzerinde sag click yapalim
        WebElement cizgiliAlan=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(expectedText,actualText);
        //Tamam diyerek alert’i kapatalim
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowsList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowsList.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='navbar__logo']")).isDisplayed());
    }
}