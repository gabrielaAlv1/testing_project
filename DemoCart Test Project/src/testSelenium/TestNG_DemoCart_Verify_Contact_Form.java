package testSelenium;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoCart_Verify_Contact_Form {
  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartVerifyContactForm() throws InterruptedException {

    driver.get("https://demo.themefreesia.com/shoppingcart/");
    Thread.sleep(3000);


    driver.findElement(By.xpath("//*[@id=\"mega-menu-item-179\"]/a")).click();

    Thread.sleep(3000);


    driver.findElement(By.name("your-name")).sendKeys("John Doe");

    Thread.sleep(3000);


    driver.findElement(By.name("your-email")).sendKeys("JohnDoe@gmail.com");

    Thread.sleep(3000);


    driver.findElement(By.name("your-subject")).sendKeys("Contact Verification");

    Thread.sleep(3000);

    driver.findElement(By.name("your-message")).sendKeys("Test Message");

    Thread.sleep(3000);

    driver.findElement(By.xpath("//*[@id=\"wpcf7-f181-p177-o1\"]/form/p[5]/input")).click();

    Thread.sleep(3000);
    
    JavascriptExecutor scroll = (JavascriptExecutor) driver;
    scroll.executeScript("window.scrollBy(0, 600)");

    Thread.sleep(3000);

    TakesScreenshot screenshot = (TakesScreenshot) driver;

    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File des =
        new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\contactFormScreenShot.png");

    try {
      FileHandler.copy(src, des);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @AfterTest
  public void tearDownTest() {

    driver.close();
    // driverInternetExplorer.close();
    System.out.println("Completed Test:");

  }
}
