package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                                          "https://wayfair.com/",
                                          "https://walmart.com",
                                          "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get(urls.get(0));
        String title1 = driver.getTitle().toLowerCase().replace(" ","");

        if(urls.get(0).contains(title1)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }


        driver.get(urls.get(1));
        String title2 = driver.getTitle();

        if(urls.get(1).contains(title2)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }



        driver.get(urls.get(2));
        String title3 = driver.getTitle().toLowerCase().replace(" ","");

        if(urls.get(2).contains(title3)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }



        driver.get(urls.get(3));
        String title4 = driver.getTitle().toLowerCase().replace(" ","");

        if(urls.get(3).contains(title4)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        driver.quit();


    }

}
