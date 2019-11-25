package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCases1 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
            driver = BrowserFactory.getDriver("chrome");
            driver.get("https://practice-cybertekschool.herokuapp.com");
            driver.manage().window().maximize();
    }
    /*
      Step 1. Go to https://practice- cybertekschool.herokuapp.com
      Step 2. Click on “Sign Up For Mailing List”
      Step 3. Enter any valid name
      Step 4. Enter any valid email
      Step 5. Click on “Sign Up” button
      Expected result: Following message should be displayed: “Thank you for signing up.
      Click the button below to return to the home page.” Home button should be displayed.
     */

    @Test(description = "Verify the message and home button")
    public void test1 () throws InterruptedException {
        // finding the element be the text
        // everything between > < is a text
        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();

        WebElement name = driver.findElement(By.cssSelector("[type='text'][name='full_name']"));
        name.sendKeys("Kateryna");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("KSemenenko@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='radius'][name='wooden_spoon']")).click();

        // Verifying the massage
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//h3[@class='subheader']")).getText();
        Assert.assertEquals(expected,actual,"FAIL");

        // Verifying that home button is displayed
        WebElement homeButton = driver.findElement(By.id("wooden_spoon"));
        Assert.assertTrue(homeButton.isDisplayed(),"Home button is not displayed");



    }

    /*
        Step 1. Go to https://practice-cybertekschool.herokuapp.com
        Step 2. Verify that number of listed examples is equals to 48.
        Hint: use findElements() and size() methods.
     */

    @Test (description = " Verify that number of listed examples is equals to 48 ")
    public void test2() {
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='list-group-item']"));
        int expected = 48;
        Assert.assertEquals(list.size(),expected,"Number of listed examples is not equal to 48");

    }

    @Test (description = " Verify that result message is displayed: “Clicked on button one!” ")
    public void test3() {
         driver.findElement(By.linkText("Multiple Buttons")).click();
         driver.findElement(By.cssSelector("[onclick='button1()']")).click();
         String expected = "Clicked on button one!";
         String actual = driver.findElement(By.id("result")).getText();
         Assert.assertEquals(expected, actual, "Message is wrong");
    }

    @Test (description = "Verify that warning message is displayed: FIRST NAME box")
    public void testCase4() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@type='text'][@name='firstname']")).sendKeys("123");
        // String expected = "first name can only consist of alphabetical letters";
        WebElement result = driver.findElement(By.xpath("//*[@class = 'help-block'][3] "));
        //  Assert.assertEquals(expected,actual);
        Assert.assertTrue(result.isDisplayed());

    }

    @Test (description = "Verify that warning message is displayed: LAST NAME box")
    public void testCase5() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("lastname")).sendKeys("123");
        WebElement result = driver.findElement(By.cssSelector("[class='help-block'][data-bv-result='INVALID']"));
        Assert.assertTrue(result.isDisplayed());

    }

    @Test (description = "Verify that warning message is displayed: USERNAME box")
    public void testCase6() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        WebElement result = driver.findElement(By.cssSelector("[data-bv-for='username'][data-bv-validator='stringLength']"));
        Assert.assertTrue(result.isDisplayed(),"Wrong message");
    }

    @Test (description = "Verify that warning message is displayed: EMAIL box")
    public void testCase7() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[placeholder*='email']")).sendKeys("esters@email");
        WebElement message1 = driver.findElement(By.xpath("//small[@data-bv-validator='emailAddress']"));
        WebElement message2 = driver.findElement(By.cssSelector("[data-bv-validator='regexp'][data-bv-for='email']"));
        Assert.assertTrue(message1.isDisplayed(), "First message is NOT displayed");
        Assert.assertTrue(message2.isDisplayed(), "Second message is NOT displayed");
    }

    @Test (description = "Verify that warning message is displayed: PHONE box")
    public void testCase8() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector(".form-control[name='phone']")).sendKeys("5711234354");
        WebElement message = driver.findElement(By.xpath("//*[contains(text(),'Phone format is not correct')] [@class='help-block']"));
        Assert.assertTrue(message.isDisplayed(), "Message is NOT displayed");
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
