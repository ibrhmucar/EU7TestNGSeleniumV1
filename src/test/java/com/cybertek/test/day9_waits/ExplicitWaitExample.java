package com.cybertek.test.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver =  WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test

    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.manage().window().setPosition(new Point(1300, 0));
        WebElement start = driver.findElement(By.xpath("(//button)[1]"));
        start.click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver,100);

        wait.until(ExpectedConditions.visibilityOf(usernameInput));


        usernameInput.sendKeys("MikeSmith");





    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("(//button)[2]")).click();



        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));// wait until this condition can occur
        inputBox.sendKeys("MikeSmith");

    }
}
