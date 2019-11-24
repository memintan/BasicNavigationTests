package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class TestCases3 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
    }


    @Test
    public void test1() {
        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEvents));
        calendarEvents.click();

        WebElement options = driver.findElement(By.cssSelector(".btn btn-link dropdown-toggle"));
        Assert.assertTrue(options.isDisplayed(), "Option button is not displayed");




    }


   @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
