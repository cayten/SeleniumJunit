package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {

        WebDriver driver;
        @Before // Before her @Test annotations dan once calisir
        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        @Test
        public void method1(){
            //amazon a gidelim
            driver.get("https://www.amazon.com.tr");
        }
        @Test
        public void method2(){
            //facebook  a gidelim
            driver.get("https://www.facebook.com");
        }
        @After
        public void tearDown(){
            driver.quit();
        }
}
