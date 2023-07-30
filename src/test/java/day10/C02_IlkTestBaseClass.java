package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;
public class C02_IlkTestBaseClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1(){
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@class='a-link-emphasis']")).click();
    }
}






