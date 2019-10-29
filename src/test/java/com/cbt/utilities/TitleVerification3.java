package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                "https://wayfair.com/",
                "https://walmart.com",
                "https://westelm.com/");

        // 1
        WebDriver driver1 = BrowserFactory.getDriver("chrome");
        driver1.manage().window().maximize();

        driver1.get(urls.get(0));
        String title1 = driver1.getTitle().toLowerCase().replace(" ","");

        if(urls.get(0).contains(title1)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver1.quit();

        // 2
        WebDriver driver2 = BrowserFactory.getDriver("chrome");
        driver2.manage().window().maximize();

        driver2.get(urls.get(1));
        String title2 = driver2.getTitle().toLowerCase().replace(" ","");

        if(urls.get(1).contains(title2)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
       driver2.quit();


        // 3
        WebDriver driver3 = BrowserFactory.getDriver("chrome");
        driver3.manage().window().maximize();

        driver3.get(urls.get(2));
        String title3 = driver3.getTitle().toLowerCase().replace(" ","");

        if(urls.get(2).contains(title3)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver3.quit();

        // 4
        WebDriver driver4 = BrowserFactory.getDriver("chrome");
        driver4.manage().window().maximize();

        driver4.get(urls.get(3));
        String title4 = driver4.getTitle().toLowerCase().replace(" ","");

        if(urls.get(3).contains(title4)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver4.quit();


    }



}
