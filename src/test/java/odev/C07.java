package odev;

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

public class C07 {

// ...Exercise3...
// go to url : https://www.techlistic.com/p/selenium-practice-form.html
//fill the firstname
//fill the lastname
//check the gender
//check the experience
//fill the date
//choose your profession -> Automation Tester
//choose your tool -> Selenium Webdriver
//choose your continent -> Antartica
//choose your command  -> Browser Commands
//click submit button


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
    public void test() throws InterruptedException {
    // go to url : https://www.techlistic.com/p/selenium-practice-form.html
    driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

    //fill the firstname
    // fill the lastname

    WebElement firstName= driver.findElement(By.xpath("//*[@name='firstname']"));
    firstName.sendKeys("ayto");

    WebElement lastName= driver.findElement(By.xpath("//*[@name='lastname']"));
    lastName.sendKeys("soylooo");

    //check the gender
    driver.findElement(By.xpath("//*[@id='sex-1']")).click();

    //check the experience
    driver.findElement(By.xpath("//*[@id='exp-4']")).click();

    //fill the date
    WebElement date= driver.findElement(By.xpath("//*[@id='datepicker']"));
    date.sendKeys("07/30/2023");

    Actions actions = new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    //choose your profession -> Automation Tester
    actions.sendKeys(Keys.TAB).perform();
   driver.findElement(By.xpath("//*[@id='profession-1']")).click();

    Thread.sleep(1000);
    actions.sendKeys(Keys.TAB).perform();

    //choose your tool -> Selenium Webdriver
    driver.findElement(By.xpath("//*[@id='tool-2']")).click();

    //choose your continent -> Antartica
    driver.findElement(By.xpath("//*[@id='continents']")).sendKeys("Antartica");

    //choose your command  -> Browser Commands
    driver.findElement(By.xpath("(//*[@style='margin:0;padding-bottom:0;padding-left:0;padding-right:0'])[8]")).click();

    ////click submit button
    driver.findElement(By.xpath("//*[@id='submit']")).click();


}
}
