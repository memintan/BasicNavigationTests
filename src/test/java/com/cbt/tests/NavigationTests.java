package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    public static void main(String[] args) throws InterruptedException {
      chromeTest();
      firefoxTest();
     // edgeTest();

    }

     public static void chromeTest() throws InterruptedException{
         // open the browser
         WebDriver driver = BrowserFactory.getDriver("chrome");
         // Full screen
         driver.manage().window().fullscreen();
         // Go to website
         driver.get("https://google.com");
         // Save current title
         String title1 = driver.getTitle();
         // System.out.println(title1);
         // Go to https://etsy.com
         driver.get(" https://etsy.com");
         // Save the title in a string variable
         String title2 = driver.getTitle();
         // Navigate back to previous page
         driver.navigate().back();
         // Verify that title is same is in step 3
         StringUtility.verifyEquals(title1, driver.getTitle());
         // Navigate forward to previous page
         driver.navigate().forward();
         // Verify that title is same is in step 5
         StringUtility.verifyEquals(title2, driver.getTitle());

         Thread.sleep(2000);
         driver.quit();


     }

    public static void firefoxTest() throws InterruptedException{
        // open the browser
        WebDriver driver = BrowserFactory.getDriver("firefox");
        // Full screen
        driver.manage().window().fullscreen();
        // Go to website
        driver.get("https://google.com");
        // Save current title
        String title1 = driver.getTitle();
        // System.out.println(title1);
        // Go to https://etsy.com
        driver.get(" https://etsy.com");
        // Save the title in a string variable
        String title2 = driver.getTitle();
        // Navigate back to previous page
        driver.navigate().back();
        // Verify that title is same is in step 3
        StringUtility.verifyEquals(title1, driver.getTitle());
        // Navigate forward to previous page
        driver.navigate().forward();
        // Verify that title is same is in step 5
        StringUtility.verifyEquals(title2, driver.getTitle());

        Thread.sleep(2000);
        driver.quit();


    }

    public static void edgeTest() throws InterruptedException{
        // open the browser
        WebDriver driver = BrowserFactory.getDriver("edge");

        // Full screen
        driver.manage().window().fullscreen();
        // Go to website
        driver.get("https://google.com");
        // Save current title
        String title1 = driver.getTitle();
        // System.out.println(title1);
        // Go to https://etsy.com
        driver.get(" https://etsy.com");
        // Save the title in a string variable
        String title2 = driver.getTitle();
        // Navigate back to previous page
        driver.navigate().back();
        // Verify that title is same is in step 3
        StringUtility.verifyEquals(title1, driver.getTitle());
        // Navigate forward to previous page
        driver.navigate().forward();
        // Verify that title is same is in step 5
        StringUtility.verifyEquals(title2, driver.getTitle());

        Thread.sleep(2000);
        driver.quit();


    }


}
