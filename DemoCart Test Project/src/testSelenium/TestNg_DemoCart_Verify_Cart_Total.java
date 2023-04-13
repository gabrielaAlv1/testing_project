package testSelenium;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNg_DemoCart_Verify_Cart_Total {

  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartVerifyCartTotal() throws InterruptedException {

    TakesScreenshot screenshot = (TakesScreenshot) driver;
    // Go to demo Cart Site
    driver.get("https://demo.themefreesia.com/shoppingcart/");
    Thread.sleep(3000);
    
    // Add item to cart
    driver
        .findElement(
            By.xpath("//*[@id=\"shoppingcart_product_grid_column_widget-2\"]/div/div[1]/div/div/a"))
        .click();

    Thread.sleep(3000);
    
    // Go to cart page link
    driver.findElement(By.xpath("//*[@id=\"site-branding\"]/div/div[2]/div[2]/div[1]/a/i")).click();

    Thread.sleep(3000);
    
    //Take Screenshot
    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File des =
        new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\cartTotalScreenshot1.png");

    try {
      FileHandler.copy(src, des);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //Go back to product home page
    driver.navigate().back();
    
    // Add second item to cart
    driver
        .findElement(
            By.xpath("//*[@id=\"shoppingcart_product_grid_column_widget-2\"]/div/div[2]/div/div/a"))
        .click();

    Thread.sleep(3000);
    // Go to cart page
    driver.findElement(By.xpath("//*[@id=\"site-branding\"]/div/div[2]/div[2]/div[1]/a/i")).click();

    Thread.sleep(3000);
    // take screenshot
    src = screenshot.getScreenshotAs(OutputType.FILE);
    des = new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\cartTotalScreenshot2.png");

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
