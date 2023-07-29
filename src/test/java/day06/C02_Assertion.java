package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
/*
- Amazon sayfasına gidelim
4 farklı test methodu oluşturalım
  a-Url'nin amazon içerdiğini test edelim
  b-Title'in facebook içermediğini test edelim
  c- sol üst köşede amazon logosunun göründüğünü test edelim
  d- Url'nin www.facebook.com olduğunu test edin

 */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
    }

    @Test
    public void method1() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "Amazon";
        // Assert.assertTrue(actualURL.contains(expectedURL));
        Assert.assertFalse(actualURL.contains(expectedURL));
    }

    @Test
    public void method2() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook-";
        // Assert.assertTrue(actualURL.contains(expectedURL));
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

    @Test
    public void method3() {
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void method4() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "www.facebook.com";
        Assert.assertFalse(actualURL.contains(expectedURL));
    }
}
