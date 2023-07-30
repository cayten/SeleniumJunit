package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C01_Iframe {
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
        //driver.close();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
          /*
    Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse bu video'yu direk locate edip
    çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
    Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip
    çalıştırabiliriz.
     */
        /*
        driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]")).sendKeys(Keys.PAGE_DOWN);
Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]")).click();
         */
        List<WebElement> iframeList=driver.findElements(By.xpath("//iframe"));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Play']")).click();
    }

}
