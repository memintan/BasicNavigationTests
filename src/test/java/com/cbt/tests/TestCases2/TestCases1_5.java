package com.cbt.tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases1_5 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @Test (description = "Verify that warning message is displayed")
    public void test1() {
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        WebElement message = driver.findElement(By.xpath("//form//div[8]//div//small[2]"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "The date of birth is not valid";
        String actual = message.getText();
        Assert.assertEquals(expected,actual, "Messages are not same");

    }

    @Test (description = "Verify that following options for programming languages are displayed")
    public void test2() {
        List<WebElement> progLanguages = driver.findElements(By.cssSelector("[class = 'form-check form-check-inline'] label"));
        for (WebElement each : progLanguages) {
            Assert.assertTrue(each.isDisplayed(), "Element "+ each.getText()+ " is not displayed");
        }

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[class = 'form-check form-check-inline'] input"));
        for (int i=0; i<checkBoxes.size(); i++) {
            Assert.assertTrue(checkBoxes.get(i).isEnabled());
        }

     /*
        WebElement c = driver.findElement(By.cssSelector("[class = 'form-check form-check-inline']:nth-child(1) label"));
        Assert.assertTrue(c.isDisplayed());
        WebElement java = driver.findElement(By.cssSelector("[class = 'form-check form-check-inline']:nth-child(2) label"));
        Assert.assertTrue(java.isDisplayed());
        WebElement javaScript = driver.findElement(By.cssSelector("[class = 'form-check form-check-inline']:nth-child(3) label"));
        Assert.assertTrue(javaScript.isDisplayed());

      */
    }

    @Test (description = "Verify that warning message is displayed: 'first name must be more than 2 and less than 64 characters long'")
    public void test3() {
        driver.findElement(By.name("firstname")).sendKeys("s");
        WebElement message = driver.findElement(By.xpath("//*[text() = 'first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "first name must be more than 2 and less than 64 characters long";
        String  actual = message.getText();
        Assert.assertEquals(expected,actual);

    }

    @Test (description = "Verify that warning message is displayed: 'The last name must be more than 2 and less than 64 characters long'")
    public void test4() {
        driver.findElement(By.cssSelector("[name = 'lastname']")).sendKeys("k");
        WebElement message = driver.findElement(By.cssSelector("[class='form-group has-feedback has-error'] div small:nth-of-type(2)"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = message.getText();
        Assert.assertEquals(expected,actual, "Warning message is displayed, but not equals to: \""+expected+"\"");

    }

    @Test (description = "Complete registration")
    public void test5() throws InterruptedException {
        driver.findElement(By.name("firstname")).sendKeys("Kateryna");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("Semenenko");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#registrationForm div:nth-of-type(3) div input")).sendKeys("KSemenenko");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#registrationForm div:nth-of-type(4) div input")).sendKeys("semenenko@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#registrationForm div:nth-of-type(5) div input")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='registrationForm']//div[6]//div//input")).sendKeys("123-456-7890");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='radio' and @ value = 'female']")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("birthday")).sendKeys("07/22/1997");
        Thread.sleep(1000);
        WebElement depElement = driver.findElement(By.cssSelector("[name = 'department']"));
        Select department = new Select(depElement);
        department.selectByValue("DE");
        Thread.sleep(1000);
        WebElement jobElement = driver.findElement(By.name("job_title"));
        Select jobTitle = new Select(jobElement);
        jobTitle.selectByVisibleText("SDET");
        Thread.sleep(1000);
        List<WebElement> languages = driver.findElements(By.cssSelector("[class = 'form-check form-check-inline']>input"));
        for (WebElement lang : languages) {
            lang.click();
            Thread.sleep(500);
        }

        driver.findElement(By.id("wooden_spoon")).click();
        WebElement message = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "You've successfully completed registration!";
        String actual = message.getText();
        Assert.assertEquals(expected,actual, "Warning message is displayed, but not equals to: \""+expected+"\"");


    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
