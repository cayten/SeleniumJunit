package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import javax.swing.*;
public class C03_Actions extends TestBaseBeforeAfter {
    // - Amazon sayfasına gidelim
    // - Account menusunden create a list linkine tıklayalım
    @Test
    public void test() {
        // - Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.xpath("//*[@class='a-link-emphasis']")).click();
        WebElement accountlist= driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountlist).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
        // - Account menusunden create a list linkine tıklayalım
        driver.findElement(By.xpath("//*[@class='nav-text']")).click();
    }
}







