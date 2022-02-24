package com.cybertek.test.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

       //go to the http://practice.cybertekschool.com/forgot_password page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().setPosition(new Point(1200,0));

        //get url name
        String url = driver.getCurrentUrl();

        //enter mike@cybertek.com to mail adress box
        WebElement mailbox = driver.findElement(By.name("email"));
        mailbox.sendKeys("mike@cybertek.com");

        //after enter the mail and click send button
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();

        //after send the mail and take curruntURL
        String last = driver.getCurrentUrl();

        //compare the first and last url
        if(url.equals(last)){
            System.out.println("Pass");
        }else{
            System.out.println("last url has been changed");
        }

        Thread.sleep(5000);
        driver.quit();


    }
}
