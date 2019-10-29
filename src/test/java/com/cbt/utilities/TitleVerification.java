package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) throws InterruptedException {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(urls.get(0));
        String title1 = driver.getTitle();
        Thread.sleep(2000);

        driver.get(urls.get(1));
        String title2 = driver.getTitle();
        Thread.sleep(2000);

        driver.get(urls.get(2));
        String title3 = driver.getTitle();
        Thread.sleep(2000);
        driver.close();

        if(title1.equals(title2) && title1.equals(title3)){
            System.out.println("All URLs have the same title");

        } else {
            System.out.println("Titles are not equal");
        }



        if(urls.get(0).startsWith("http://practice.cybertekschool.com") &&
                urls.get(1).startsWith("http://practice.cybertekschool.com" ) &&
                     urls.get(2).startsWith("http://practice.cybertekschool.com")) {
            System.out.println("TRUE");
            System.out.println("All pages start with http://practice.cybertekschool.com");
        } else {
                System.out.println("FALSE");
            }

        }

    }


