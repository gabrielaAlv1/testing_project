package testSelenium;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoCart_Verify_Checkout {
  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartVerifyCheckoutTest() throws InterruptedException {
    // Go to Demo Cart Site
    driver.get("https://demo.themefreesia.com/shoppingcart/");
    driver.manage().window().maximize();
    Thread.sleep(1000);
    
    // Select Product Item 1
    driver
        .findElement(By.xpath("//*[@id=\"masthead\"]/div[3]/div/div/div[1]/div/nav/div/ul/li[1]/a"))
        .click();
    Thread.sleep(1000);
    
    // Add Item to Cart
    driver.findElement(By.xpath("//*[@id=\"product-156\"]/div[2]/form/button")).click();
    Thread.sleep(1000);
    
    // Go to product page
    driver.findElement(By.xpath("//*[@id=\"mega-menu-item-107\"]/a")).click();
    Thread.sleep(1000);

    JavascriptExecutor scroll = (JavascriptExecutor) driver;
    scroll.executeScript("window.scrollBy(0, 500)");
    
    // add Second Item to cart
    driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[6]/a[2]")).click();
    Thread.sleep(1000);

    JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
    scroll2.executeScript("window.scrollBy(0, -500)");
    
    // Go to current cart icon
    driver.findElement(By.xpath("//*[@id=\"site-branding\"]/div/div[2]/div[2]/div[1]/a/i")).click();
    Thread.sleep(1000);
    
    //Select Checkout
    driver.findElement(By.xpath(" //*[@id=\"page-102\"]/div/div/div[2]/div/div/a")).click();
    Thread.sleep(1000);
    
    // Input first name
    String firstName = "Doc";
    driver.findElement(By.id("billing_first_name")).sendKeys(firstName);
    Thread.sleep(1000);
    
    // Input Last Name
    String lastName = "Brown";
    driver.findElement(By.id("billing_last_name")).sendKeys(lastName);
    Thread.sleep(1000);
    
    // Input billing address
    String billingAddress = "1640 Riverside Drive";
    driver.findElement(By.id("billing_address_1")).sendKeys(billingAddress);
    Thread.sleep(1000);
    
    // Input city
    String townCity = "Hill Valley";
    driver.findElement(By.id("billing_city")).sendKeys(townCity);
    Thread.sleep(1000);

    JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
    scroll3.executeScript("window.scrollBy(0, 500)");
    
    // imput state by drop down menu
    String state = "California";
    driver
        .findElement(By.xpath("//*[@id=\"billing_state_field\"]/span/span/span[1]/span/span[2]/b"))
        .click();
    driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(state);
    driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(Keys.RETURN);
    Thread.sleep(1000);
    
    // input zip code
    String zip = "95420";
    driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys(zip);
    Thread.sleep(1000);
    
    // input phone number
    String phone = "1112223333";
    driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys(phone);
    Thread.sleep(1000);
    
    // input email address
    String email = "docBrown@gmail.com";
    driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys(email);
    Thread.sleep(1000);
    
    // select place order
    driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
    Thread.sleep(2000);

    JavascriptExecutor scroll4 = (JavascriptExecutor) driver;
    scroll4.executeScript("window.scrollBy(0, -600)");
    
    // take screen shot
    TakesScreenshot screenshot = (TakesScreenshot) driver;

    File src = screenshot.getScreenshotAs(OutputType.FILE);
    File des =
        new File("C:\\Users\\henry\\Desktop\\Screenshot for Testing\\checkOutScreenshot.png");

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
