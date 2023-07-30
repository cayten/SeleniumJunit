package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */

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

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //Verify that home page is visible successfully
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();

        //Click on 'Signup / Login' button
        WebElement singupLogin = driver.findElement(By.xpath("//*[@href=\"/login\"]"));
        singupLogin.click();

        //Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();

        //Enter name and already registered email address

        WebElement name= driver.findElement(By.xpath("//*[@type='text']"));
        name.sendKeys("yuhi");

        WebElement email= driver.findElement(By.xpath("(//*[@type='email'])[2]"));
       email.sendKeys("ayto@gmail.com");


       //Click 'Signup' button
        WebElement signup= driver.findElement(By.xpath("(//*[@class='btn btn-default'])[2]"));
        signup.click();

        //Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());









    }
}
