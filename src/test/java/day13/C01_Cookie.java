package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;
import java.util.Set;
public class C01_Cookie extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[text()='Try different image']")).click();
        //-tum cookie’leri listeleyin
        Set<Cookie> tumCokkie=driver.manage().getCookies();
        System.out.println(tumCokkie);
        int sayac=1;
        for (Cookie w:tumCokkie) {
            System.out.println(sayac+". cokkie :"+w);
            System.out.println(sayac+". cokkie :"+w.getName());
            System.out.println(sayac+". cokkie :"+w.getValue());
            System.out.println(sayac+". cokkie :"+w.getDomain());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=tumCokkie.size();
        Assert.assertTrue(cookieSayisi>5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:tumCokkie) {
            if(w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumCokkie=driver.manage().getCookies();
        sayac=1;
        for (Cookie w:tumCokkie) {
            System.out.println(sayac+". cokkie :"+w);
            System.out.println(sayac+". cokkie :"+w.getName());
            System.out.println(sayac+". cokkie :"+w.getValue());
            System.out.println(sayac+". cokkie :"+w.getDomain());
            sayac++;
        }
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCokkie.contains(yeniCookie));
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCokkie=driver.manage().getCookies();
        sayac=1;
        for (Cookie w:tumCokkie) {
            System.out.println(sayac+". cokkie :"+w);
            System.out.println(sayac+". cokkie :"+w.getName());
            System.out.println(sayac+". cokkie :"+w.getValue());
            System.out.println(sayac+". cokkie :"+w.getDomain());
            sayac++;
        }
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCokkie=driver.manage().getCookies();
        Assert.assertTrue(tumCokkie.isEmpty());
    }
}