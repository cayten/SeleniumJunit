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

public class C03 {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
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
    public void tearDown(){

    }
    @Test
    public void test() throws InterruptedException {

        //Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //Verify that home page is visible successfully
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();

        //Click on 'Signup / Login' button
        WebElement singupLogin= driver.findElement(By.xpath("//*[@href=\"/login\"]"));
        singupLogin.click();

        //Verify 'Login to your account' is visible
        driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();

        //Enter correct email address and password
        WebElement email= driver.findElement(By.xpath("//*[@placeholder='Email Address']"));
        email.sendKeys("ayto@gmail.com");

        WebElement password= driver.findElement(By.xpath("//*[@placeholder='Password']"));
        password.sendKeys("159753");

        //Click 'login' button
        WebElement login =driver.findElement(By.xpath("//*[@class='btn btn-default']"));
        login.click();


        //Verify that 'Logged in as username' is visible
        driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed();

        //Click 'Logout' button
        WebElement logout= driver.findElement(By.xpath("//*[@class='fa fa-lock']"));
        logout.click();

        //Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("By.xpath(\"//*[@action='/login']\")")).isDisplayed());



    }
}
