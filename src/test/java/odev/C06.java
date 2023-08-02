package odev;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C06 {
    // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
// ikinci emojiye tıklayın (hayvan emojisini seçin)
// tüm hayvan emojilerine tıklayın
// formu doldurun (dilediğinizi yazabilirsiniz)
// apply butonuna tıklayın

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {

    }

    @Test
   public void test () throws InterruptedException {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        Thread.sleep(1000);
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement animal=driver.findElement(By.xpath("//*[@id='emoojis']"));
         animal.click();

        // tüm hayvan emojilerine tıklayın


        // formu doldurun (dilediğinizi yazabilirsiniz)
        Actions actions=new Actions(driver);
       Faker faker=new Faker();
       WebElement text=driver.findElement(By.xpath("(//*[@class='mdl-textfield mdl-js-textfield mdl-textfield--floating-label is-upgraded'])[1]"));
       text.click();

        actions.click(text).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                sendKeys(faker.name().name()).sendKeys(Keys.TAB).
                perform();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='send']")).click();



    }
}
