package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Asertion {

    /*
    Bir Class olusturalim YanlisEmailTesti
  http://automationpractice.com/index.php sayfasina gidelim
  Sign in butonuna basalim
  Email kutusuna @isareti olmayan bir mail yazip enter’a
  bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
  /*  Bir Class olusturalim YanlisEmailTesti
    https://www.automationexercise.com/ sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
 */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
    }
    @Test
    public void name() throws InterruptedException {
        WebElement signIn = driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        signIn.click();
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("cuneyt");
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("cuneyt.com");
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='signup']")).isDisplayed());


    }

    }
