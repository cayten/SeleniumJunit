package odev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
     */


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("http://automationexercise.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();

        WebElement singupLogin= driver.findElement(By.xpath("//*[@href=\"/login\"]"));
        singupLogin.click();

        driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed();

        WebElement email= driver.findElement(By.xpath("//*[@placeholder='Email Address']"));
        email.sendKeys("ayto@gmail.com");

        WebElement password= driver.findElement(By.xpath("//*[@placeholder='Password']"));
        password.sendKeys("15975355");

        driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));







    }
}







