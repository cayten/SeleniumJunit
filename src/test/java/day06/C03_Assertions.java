package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
     ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
            ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
     ○ logoTest => BestBuy logosunun görüntülendigini test edin
     ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown() {
        //driver.close();
    }
    @Test
    public void method1() {
        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.bestbuy.com/";
        Assert.assertTrue(actualURL.contains(expectedURL));
    }
    @Test
    public void method2() {
        String actualTitle=driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void method3() {
        WebElement logo= driver.findElement(By.xpath("(//*[@class=\"logo\"])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void method4() {
        WebElement franceLink= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(franceLink.isDisplayed());
    }
}
