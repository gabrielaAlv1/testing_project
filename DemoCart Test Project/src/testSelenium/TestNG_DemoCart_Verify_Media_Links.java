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

public class TestNG_DemoCart_Verify_Media_Links {
  WebDriver driver = null;

  @BeforeTest
  public void setUpTest() {
    System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\henry\\Desktop\\selenium\\geckodriver-v0.32.2-win32\\geckodriver.exe");
    driver = new FirefoxDriver();
    driver.manage().window().maximize();

  }

  @Test
  public void demoCartVerifyMediaLinksTest() throws InterruptedException {

    driver.get("https://demo.themefreesia.com/shoppingcart/");

    // Open a tab to a second page from the home page
    Thread.sleep(1000);

    // Click all options in the top media link menu

    // Login Button
    WebElement loginButton = driver.findElement(By.id("mega-menu-item-122"));
    loginButton.click();
    Thread.sleep(1500);

    // My Account Button
    WebElement myAccountButton = driver.findElement(By.id("mega-menu-item-121"));
    myAccountButton.click();
    Thread.sleep(1500);

    // linkedIn Button
    WebElement linkedInButton = driver.findElement(By.id("menu-item-434"));
    linkedInButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // flickr Button
    WebElement flickrButton = driver.findElement(By.id("menu-item-433"));
    flickrButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // instagram Button
    WebElement instagramButton = driver.findElement(By.id("menu-item-432"));
    instagramButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // dribbble Button
    WebElement dribbbleButton = driver.findElement(By.id("menu-item-431"));
    dribbbleButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // pinterest Button
    WebElement pinterestButton = driver.findElement(By.id("menu-item-430"));
    pinterestButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // Google+ Button
    WebElement googleButton = driver.findElement(By.id("menu-item-429"));
    googleButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // Twitter Button
    WebElement twitterButton = driver.findElement(By.id("menu-item-428"));
    twitterButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

    // Facebook Button
    WebElement facebookButton = driver.findElement(By.id("menu-item-112"));
    facebookButton.click();
    Thread.sleep(1500);
    // Send Back to Previous Webpage
    driver.navigate().back();
    Thread.sleep(1000);

  }

  @AfterTest
  public void tearDownTest() {

    driver.close();
    // driverInternetExplorer.close();
    System.out.println("Completed Test:");

  }
}
