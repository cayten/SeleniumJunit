package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {

/*
●https://www.amazon.com/ adresinegidin.
           -Test1
           Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
           oldugunu testedin
           -Test2
           1.Kategori menusunden Books seceneginisecin
           2.Arama kutusuna Java yazin vearatin
           3.Bulunan sonuc sayisiniyazdirin
           4.Sonucun Java kelimesini icerdigini testedin
 */

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[text()='Try different image']")).click();
    }
    @Test
    public void test1() {
        List<WebElement> dd=driver.findElements(By.xpath("//option"));
        System.out.println(dd.size());
        for (WebElement w:dd) {
            System.out.println(w.getText());
        }
        int actualDropDown= dd.size();
        int expectedDropDown=45;
        Assert.assertNotEquals(expectedDropDown,actualDropDown);
    }
    @Test
    public void test2() {
        //Kategori menusunden Books seceneginisecin
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Books");
//Arama kutusuna Java yazin vearatin
        WebElement searchbox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchbox.sendKeys("Java", Keys.ENTER);
        //Bulunan sonuc sayisiniyazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        System.out.println(sonucYazisi.getText());
//Sonucun Java kelimesini icerdigini testedin
        String actualText=sonucYazisi.getText();
        String expectedText="Java";
        Assert.assertTrue(actualText.contains(expectedText));
    }







}
