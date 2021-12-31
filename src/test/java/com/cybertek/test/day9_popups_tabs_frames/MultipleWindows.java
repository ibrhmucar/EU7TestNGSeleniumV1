package com.cybertek.test.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows {
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
    public void SwitchWindowsTest(){

        driver.get("http://practice.cybertekschool.com/windows");

     //   WebElement clikcHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
     //   clikcHere.click();

        System.out.println("Title before new window:" + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after new window:" + driver.getTitle());




    }
}
