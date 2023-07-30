package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_WindowHandle {
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
//4- title'in BestBuy içerdiğini test edelim
//5- İlk sayfaya dönüp sayfada java aratalım
//6- Arama sonuclarının java içerdiğini test edelim
//7- Yeniden bestbuy sayfasına gidelim
//8- Logonun görünürlüğünü test edelim
/*
    Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
    driver'in window handle değerini string bir değişkene atarız
    Sonrasında farklı bir sayfaya yada sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
    String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
     */
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@class='a-link-emphasis']")).click();
        String amazonWindowHandle=driver.getWindowHandle();
        System.out.println(amazonWindowHandle);
        //2- Url'nin amazon içerdiğini test edelim
        String actualURL=driver.getCurrentUrl();
        String expectedURL="amazon";
        Assert.assertTrue(actualURL.contains(expectedURL));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();
        //4- title'in BestBuy içerdiğini test edelim
        String actualURLBestBuy=driver.getCurrentUrl();
        String expectedURLBestBuy="BestBuy";
        Assert.assertFalse(actualURLBestBuy.contains(expectedURLBestBuy));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);
        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement actualSonuc= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedSonuc="java";
        Assert.assertTrue(actualURL.contains(expectedURL));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());
    }
}
