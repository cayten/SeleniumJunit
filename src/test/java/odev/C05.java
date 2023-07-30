package odev;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

public class C05 {

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
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

        //Click on 'Contact Us' button
        WebElement contactUs= driver.findElement(By.xpath("//*[@class='fa fa-envelope']"));
        contactUs.click();

        //Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed());

        //Enter name, email, subject and message
        WebElement name= driver.findElement(By.xpath("(//*[@class='form-control'])[1]"));
        name.sendKeys("ayten");
        Thread.sleep(1000);

        WebElement email= driver.findElement(By.xpath("(//*[@class='form-control'])[2]"));
        email.sendKeys("ayten@gmail.com");
        Thread.sleep(1000);

        WebElement subject= driver.findElement(By.xpath("(//*[@class='form-control'])[3]"));
        subject.sendKeys("java");
        Thread.sleep(1000);

        WebElement message= driver.findElement(By.xpath("(//*[@class='form-control'])[4]"));
        message.sendKeys("odevlerinizi duzenli yapin yoksa esiniz gereksiz uzerinize gerliyor");
        Thread.sleep(2000);

        //Upload file
       // driver.findElement(By.xpath("//*[@type='file']")).submit();
        //Thread.sleep(2000);


        //Click 'Submit' button
        WebElement submit= driver.findElement(By.xpath("//*[@class='btn btn-primary pull-left submit_form']"));
        submit.click();
        Thread.sleep(1000);


        //Click OK button
        driver.switchTo().alert().accept();


        //Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed());
        Thread.sleep(1000);

        //Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());















    }
}
