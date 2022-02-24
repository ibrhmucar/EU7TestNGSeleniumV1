package com.cybertek.test.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;

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

        String name = driver.getWindowHandle();


        Set<String> windowHandles = driver.getWindowHandles();


        for (String handle : windowHandles) {

            if(!handle.equals(name)){
                driver.switchTo().window(handle);
            }

        }

        System.out.println("Title after switch new window  :  " + driver.getTitle());
    }
    
    @Test
    
    public void moreThan2Window(){
        
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Before switch : " + driver.getTitle());
        
        Set<String> windowsHandles = driver.getWindowHandles();

        for (String handle : windowsHandles) {
            driver.switchTo().window(handle);

            if(driver.getTitle().equals("New Windows")){
                break;
            }
            
        }

        System.out.println("After switch title : " + driver.getTitle());
        
        
        
    }
    
    
    
    
    
    
}





