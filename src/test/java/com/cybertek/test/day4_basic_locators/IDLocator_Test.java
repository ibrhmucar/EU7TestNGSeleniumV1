package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocator_Test {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().setPosition(new Point(1200,0));


        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();

        Thread.sleep(5000);

        driver.quit();



    }
}
