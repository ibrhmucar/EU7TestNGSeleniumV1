package com.cybertek.test.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver =  WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        driver.manage().window().setPosition(new Point(1300,0));


        Thread.sleep(7000);

       // driver.findElement(By.xpath("//input[@type='username']")).sendKeys("MikeSmith");
        driver.findElement(By.id("username")).sendKeys("MikeSmith");


    }

}
