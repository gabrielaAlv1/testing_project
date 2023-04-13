package testSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoCart_Verify_Search_Bar {

  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {

    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartSearchBarTest() throws InterruptedException {
    
    // Go to Demo Cart Page
    driver.get("https://demo.themefreesia.com/shoppingcart/");

    Thread.sleep(3000);
    
    // Enter Dumbbell into search bar
    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("dumbbell");

    Thread.sleep(3000);
    
    // Hit enter on the search bar
    driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys(Keys.RETURN);

    Thread.sleep(3000);
    
  }

  @AfterTest
  public void tearDownTest() {

    driver.close();
    // driverInternetExplorer.close();
    System.out.println("Completed Test:");

  }
}
