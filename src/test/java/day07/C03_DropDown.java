package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    //https://the-internet.herokuapp.com/dropdown adresine gidin.
//Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//Tüm dropdown değerleri(value) yazdırın
//Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
//False yazdırın.
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddmlist= driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select=new Select(ddmlist);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===========================================");
        Thread.sleep(2000);
        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===========================================");
        Thread.sleep(2000);
        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("===========================================");
        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumddm=driver.findElements(By.xpath("//option"));
        for (WebElement i:tumddm
        ) {
            System.out.println(i.getText());
        }
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        System.out.println("dropdown daki eleman sayisi = "+tumddm.size());
        if (tumddm.size()==4){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
        Assert.assertNotEquals(4,tumddm.size());
    }








}
