package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
public class C03_Faker extends TestBaseBeforeAfter {
    /*
        Faker classını kullanma amacımız form doldurmamız gereken web sitelerde defalarca kendi üreteceğimiz veriler yerine
        bizim için rondom veriler üretir ve işimizi kolaylaştırır
        Faker classını kullanmak için mvnrepository.com adresinden java-faker kütüphanesini aratır ve ençok kullanılanı
        pom.xml dosyamıza ekleriz. Ve faker class'ından bir obje oluşturup;
        email için faker.internet() methodunu kullanarak emailAddress() methodunu seçeriz.
        password içinde aynı internet methodunu kullanırız.
        İsim ve soyisimler için faker.name() methodu ile firstname() ve lastname() methodunu kullanırız
         */
    @Test
    public void test() throws InterruptedException {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        //“create new account”  butonuna basin
        WebElement createAccount= driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions=new Actions(driver);
        actions.click(createAccount).perform();
        //“firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        WebElement firstName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        actions.click(firstName).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(faker.number().digit()).sendKeys(Keys.TAB).sendKeys("Oct").sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath("//*[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']"))).perform();
    }
}