package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_RadioButton {

    /*
   Bir class oluşturun : RadioButtonTest
   Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
           https://www.facebook.com adresine gidin
   Cookies’i kabul edin
   “Create an Account” button’una basin
   “radio buttons” elementlerini locate edin
   Secili degilse cinsiyet butonundan size uygun olani secin
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void facebook() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement createButton=driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        createButton.click();
        WebElement female= driver.findElement(By.xpath("//*[text()=\"Female\"]"));
        WebElement male= driver.findElement(By.xpath("//*[text()=\"Male\"]"));
        if (!female.isSelected()){
            female.click();
        }
        Thread.sleep(2000);
        male.click();
    }

}
