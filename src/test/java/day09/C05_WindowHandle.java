package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C05_WindowHandle {

    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //Sayfadaki textin “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
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
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String hoappWindowHandle= driver.getWindowHandle();
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
/*
Bir web sitesine gittigimizde bir web elementi tikladigimizda yeni bir sekme ya da pencere acilirsa bu yeni
acilan sekmenin handle degerini bulmak icin onu oncelikle bir liste atariz sonra listedeki ilk handle degeri 0.index ilk pencerenin
degerini verir.ikinci sekmeye ulasmak icin ise driver.swicthTo(listeadi.get(1)) yazariz
 */
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        System.out.println("window handle degerleri "+windowList);
        driver.switchTo().window(windowList.get(1));
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Thread.sleep(2000);
        String actualTitle=driver.getTitle();
        String expectedTitle="New Window";
        Assert.assertEquals(expectedTitle,actualTitle);
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}
