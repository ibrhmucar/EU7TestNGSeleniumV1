package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class verifyURLnotChanged {
    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to the "http://practice.cybertekschool.com/forgot_password"
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //click on Retrieve password
        driver.manage().window().setPosition(new Point(1200,0));
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        Thread.sleep(2000);
        retrievePasswordButton.click();

        String expectedurl = driver.getCurrentUrl();
        System.out.println(expectedurl);

        if(url.equals(expectedurl)){
            System.out.println("there is no difference");
        }else{
            System.out.println("Not mach");
        }

         driver.quit();

        }


    }

