package testSelenium;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoCart_Verify_DemoCart_Plus {


  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartPlusTest() throws InterruptedException {

    driver.get("https://demo.themefreesia.com/shoppingcart/");

    driver.manage().window().maximize();
    Thread.sleep(1000);

    // Get to the Shopping Cart Plus page
    driver.findElement(By.xpath("//*[@id=\"mega-menu-item-77\"]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("mega-menu-item-198")).click();
    Thread.sleep(2000);

    // Get to the Popular Items Page
    driver.findElement(By.id("menu-item-211")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("menu-item-338")).click();
    Thread.sleep(2000);

    // Sort Popular items by popularity
    driver.findElement(By.xpath("//*[@id=\"main\"]/form/select/option[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[5]/a[2]")).click();
    Thread.sleep(1000);

    // Open Shopping Cart and take a screenshot of the item in the cart
    driver.findElement(By.xpath("//*[@id=\"site-branding\"]/div/div[2]/div[2]/div/a/i")).click();
    Thread.sleep(1000);
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File des =
        new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\demoCartPrimeScreenshot.png");

    try {
      FileHandler.copy(src, des);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  @AfterTest
  public void tearDownTest() {

    driver.close();
    System.out.println("Completed Test:");

  }
}

