package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(1375,0));
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement tagName = driver.findElement(tagName("input"));
        tagName.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mike@mike.com");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
