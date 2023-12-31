package day13;

    import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import java.util.List;
    public class C02_WebTables extends TestBaseBeforeAfter {
        @Test
        public void test1() {
            //Bir class oluşturun : C02_WebTables
            //login( ) metodun oluşturun ve oturum açın.
            //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
            login();
            //Username : manager
            //Password : Manager1!
            //table( ) metodu oluşturun
            table();
        }
        private void table() {
         /*
        Tabloda <table> tag'ı altında tablonun başlığını gösteren <thead> tagı bulunu. Eğer başlıkta satır(row) varsa
        <thead> tag'ı altında <tr>(satır-row) tagı vardır. Ve başlıktaki sütunlara yani hücrelere(cell) de <th> tag'ı
        ile ulaşılır.
        Başlığın tablodaki verilere <tbody> tag'ı ile altındaki satırlara(row) <tr> tag'ı ile sütunlara yani hücrelere
        <td> tag'ı ile ulaşırız
         */
//Tüm table body’sinin boyutunu(sutun sayisi) bulun.
            List<WebElement> sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
            System.out.println(sutunSayisi.size());
            //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
            WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
            System.out.println("Basliklar : "+basliklar.getText());
            WebElement body=driver.findElement(By.xpath("//tbody"));
            System.out.println("Tum body : "+ body.getText());
            //table body’sinde bulunan toplam satir(row) sayısını bulun.
            //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
            List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
            System.out.println(satirSayisi.size());
            for (WebElement i:satirSayisi) {
                System.out.println(i.getText());
            }
            //4.satirdaki(row) elementleri konsolda yazdırın.
            System.out.println("Tablodaki 4. satır : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());
        }
        private void login() {
            driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
            Actions actions = new Actions(driver);
            WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
            actions.click(userName).sendKeys("manager").
                    sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
        }
    }

