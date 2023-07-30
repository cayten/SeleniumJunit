package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Iframe {

   // ● https://the-internet.herokuapp.com/iframe adresine gidin.
    // ● Bir metod olusturun: iframeTest
    //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //    ○ Text Box’a “Merhaba Dunya!” yazin.
    //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //      dogrulayin ve konsolda yazdirin
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
        // driver.close();
    }
    // ● Bir metod olusturun: iframeTest
    @Test
    public void iframeTest() throws InterruptedException {
        // ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //    ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeText=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeText.isDisplayed());
        System.out.println(iframeText.getText());
        //    ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeTextBox= driver.findElement(By.id("mce_0_ifr"));//Frame gecis yapmadan once iframe in id sini locate ettik
        driver.switchTo().frame(iframeTextBox);
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(1000);
        textBox.sendKeys("lutfen ders esnasinda guler yuzlu olalim");
        //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //      dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement text= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());
    }
}
