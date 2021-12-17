package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1350, 0));

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioBtn  = driver.findElement(By.id("green"));

       // System.out.println("greenRadioBtn.isEnabled() = " + greenRadioBtn.isEnabled());
        Assert.assertTrue(greenRadioBtn.isEnabled(),"verify green button NoT enable(disable");


    }

    @Test

    public void test2() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1350, 0));

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement enable_disable = driver.findElement(By.xpath("//input[@type='text']")); // #input-example>input



        Assert.assertFalse(enable_disable.isEnabled(),"verify if it is disable");
        System.out.println("Disable " + !enable_disable.isEnabled());

        WebElement enable_button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enable_button.click();


        Thread.sleep(5000);
        enable_disable.sendKeys("hi babe");
        Assert.assertTrue(enable_disable.isEnabled(),"verify now button is enable");
        System.out.println("Enable " + enable_button.isEnabled());
        Thread.sleep(2000);


        driver.quit();






    }




}
