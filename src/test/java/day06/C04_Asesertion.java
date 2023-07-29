package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Asesertion {

  /*
   * https://www.youtube.com adresine gidin
   * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
   * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
   * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
   * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
   * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
   */
  static WebDriver driver;

  @BeforeClass
  public static void setUp() {
    WebDriverManager.chromiumdriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://www.youtube.com");
  }

  @AfterClass
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void method1() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "YouTube";
    Assert.assertTrue(actualTitle.contains(expectedTitle));
  }

  @Test
  public void method2() {
    WebElement image = driver.findElement(By.xpath("(//*[@class='external-icon'])[1]"));
    Assert.assertTrue(image.isDisplayed());
  }

  @Test
  public void method3() {
    WebElement searchbox = driver.findElement(By.xpath("(//*[@class='ytd-searchbox-spt '])[1]"));
    Assert.assertTrue(searchbox.isEnabled());
  }

  @Test
  public void method4() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "youtube";
    Assert.assertFalse(actualTitle.contains(expectedTitle));
  }
}