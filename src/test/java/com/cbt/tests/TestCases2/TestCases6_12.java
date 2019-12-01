package com.cbt.tests.TestCases2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCases6_12 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "")
    public void test6() {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.cssSelector("[id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[name = 'full_name']")).sendKeys("Kateryna");
        BrowserUtils.wait(1);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        WebElement message = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = message.getText();
        Assert.assertEquals(expected, actual);

        for(int i=1; i<=3; i++){
            driver.navigate().back();
            BrowserUtils.wait(1);
        }

        WebElement emailCybertek = driver.findElement(By.xpath("//tr[@class='hidden-xs hidden-sm klikaciRadek newMail'][1]"));
        Assert.assertTrue(emailCybertek.isDisplayed());
        emailCybertek.click();
        String expectedSender = "do-not-reply@practice.cybertekschool.com";
        String actualSender = driver.findElement(By.cssSelector("[id = 'odesilatel']")).getText();
        Assert.assertEquals(expectedSender,actualSender, "Message is not from: "+expectedSender);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.cssSelector("[id = 'predmet']")).getText();
        Assert.assertEquals(expectedSubject,actualSubject, "Subject is not: "+expectedSubject );

    }

    @Test (description = "Verify that subject is: “File Uploaded!")
    public void test7() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/skateryna/Desktop/FileUploading check.txt");
        driver.findElement(By.id("file-submit")).click();
        String expected = "File Uploaded!";
        String actual = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expected,actual);
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'uploaded-files']")).isDisplayed());

    }

    @Test (description = "Verify that following message is displayed: “You selected: United States of America”")
    public void test8() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.name("myCountry")).sendKeys("United States of America");

    }

    @Test (description = "Verify Status Code", dataProvider = "StatusCode")
    public void test9_12(String code) {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.xpath("//a[text() = "+code+"]")).click();
        WebElement message = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(message.isDisplayed());
        String expected = "This page returned a "+code+" status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here";
        String actual = message.getText();
        Assert.assertEquals(expected,actual);


    }

    @DataProvider (name = "StatusCode" )
    public Object[] statusCode() {
        return new Object[] {
                 "200", "301", "404", "500"
        };

    }





    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
