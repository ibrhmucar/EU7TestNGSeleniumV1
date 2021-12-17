package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttirbuteTest {

    @Test

    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));

        blueRadioBtn.getAttribute("value");

        System.out.println(blueRadioBtn.getAttribute("type"));
        System.out.println(blueRadioBtn.getAttribute("name"));
        System.out.println(blueRadioBtn.getAttribute("checked"));
        System.out.println(blueRadioBtn.getAttribute("outerHTML"));
        System.out.println(blueRadioBtn.getAttribute("value"));


        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));
        System.out.println(button2.getAttribute("innerHTML"));



        driver.quit();

    }

}
