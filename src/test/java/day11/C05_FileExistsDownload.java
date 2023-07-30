package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;
import java.nio.file.Files;
import java.nio.file.Paths;
public class C05_FileExistsDownload extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //Sample.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='Sample.txt']")).click();
        Thread.sleep(2000);
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String samplePath="C:\\Users\\Ramazan\\Downloads\\Sample.txt";
        Assert.assertTrue(Files.exists(Paths.get(samplePath)));
        //İndirildiğini konsolda gösterin
        System.out.println(Paths.get(samplePath));
    }
}