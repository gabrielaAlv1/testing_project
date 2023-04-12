package testSelenium;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoCart_Verify_Add_WishList {
  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartVerifyWishList() throws InterruptedException {
    
    // Go to Demo Cart Site
    driver.get("https://demo.themefreesia.com/shoppingcart/");
    
    // Click add to wish list heart icon on first product
    WebElement product = driver.findElement(By.xpath(
        "//*[@id=\"shoppingcart_product_grid_column_widget-2\"]/div/div[1]/div/div/div/div/a"));
    product.click();
    Thread.sleep(3000);
    
    // Click wish list icon on the top right of the screen
    WebElement wishlistheart = driver.findElement(By.className("wishlist-box"));
    wishlistheart.click();
    Thread.sleep(3000);
    
    // Take Screenshot
    TakesScreenshot screenshot = (TakesScreenshot) driver;

    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File des =
        new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\wishListScreenshot.png");

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
