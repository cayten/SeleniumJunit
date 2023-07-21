package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkTest {

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            //1- https://www.amazon.com/ sayfasina gidelim
            driver.get("https://www.amazon.com.tr");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
            //       2- arama kutusunu locate edelim
            WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
            //       3- “Samsung headphones” ile arama yapalim
            searchBox.sendKeys("Samsung headphones"+ Keys.ENTER);
            //       4- Bulunan sonuc sayisini yazdiralim
            String[] result=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"))
                    .getText().split(" ");
            System.out.println("Bulunan sonuc sayisi :"+ result[0]);
            //       5- Ilk urunu tiklayalim
            driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();
            //       6- Sayfadaki tum basliklari yazdiralim
            System.out.println("birinci basliklar"+driver.findElement(By.xpath("//h1")).getText());
            System.out.println("ikinci basliklar ="+driver.findElement(By.xpath("//h2")).getText());
            System.out.println("ucuncu basliklar"+driver.findElement(By.xpath("//h3")).getText());
        }
    }

