package day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeAfter;



    public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {
        @Test
        public void test() {
            driver.get("https://www.amazon.com.tr");
            driver.findElement(By.xpath("//*[@class='a-link-emphasis']")).click();
        }
    }

