package com.cybertek.test.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver =  WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().window().setPosition(new Point(1300, 0));

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //dynamic wait for findelements

        System.out.println(driver.findElement(By.xpath("(//h4)[2]")).getText());// It's not belongs to HTML.
        //When we open the page, this elements does not appear. We get the error message which that "Unable to find element.
        //But if it is belongs to HTML, it is not important to wait. Because elements find the element that we want.


    }
}
