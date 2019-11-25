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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases3 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        Thread.sleep(2000);
        activities.click();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEvents));
        calendarEvents.click();

        WebElement loadMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loadMask));

    }


    @Test (description = "Verify that page subtitle OPTION is displayed")
    public void test1() throws InterruptedException {

        WebElement options = driver.findElement(By.xpath("//*[@class='btn btn-link dropdown-toggle']"));
        Assert.assertTrue(options.isDisplayed(), "Option button is not displayed");

    }

    @Test (description = "Verify that page number is equals to 1")
    public void test2() {

        String actual = driver.findElement(By.cssSelector("[type = 'number']")).getAttribute("value");
        Assert.assertEquals(actual, "1", "Number "+actual+" is not equal to 1");

    }

    @Test (description = "Verify that view per page number is equals to 25")
    public void test3() {

        String actual = driver.findElement(By.className("btn dropdown-toggle ")).getText();
        Assert.assertEquals(actual, "25", "Number is not equal to 25");

    }

    @Test (description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@class = 'grid-row row-click-action']"));
        System.out.println("Size: "+list.size());
        int actual = list.size();
        Assert.assertEquals(actual,22, "Number of calendar events is not equal to number of records");

    }

    @Test (description = "Verify that all calendar events were selected")
    public void test5() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-small dropdown-toggle']/child::input")).click();
        List<WebElement> list = driver.findElements(By.xpath("//input[@tabindex]"));
        Thread.sleep(1000);
        for(WebElement each: list){
            Assert.assertTrue(each.isSelected(), "Element "+each+" is not selected");
        }
    }

    @Test(description = "Verify that following data is displayed")
    public void test6() {
        driver.findElement(By.xpath("//*[text()='Testers meeting']")).click();

        WebElement mask = driver.findElement(By.cssSelector("[class = 'loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(mask));

        List<WebElement> contLabels = driver.findElements(By.xpath("//*[@class = 'control-label']"));
        for (WebElement each: contLabels) {
            Assert.assertTrue(each.isDisplayed(), "Element "+each.getText()+" is not displayed");
        }

    }


   @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
