package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
public class C01_ActionsKeyUpKeyDown extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@class='a-link-emphasis']")).click();
        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions=new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).sendKeys("samsung").sendKeys(" ").keyDown(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).perform();
        //aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }
}