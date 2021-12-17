package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(1375,0));
        driver.get("http://practice.cybertekschool.com/sign_up");


        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mike Smith");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("mike@mike.com");


        // second way
       // driver.findElement(By.name("email")).sendKeys("Ahmet Mehmet");

        WebElement click = driver.findElement(By.name("wooden_spoon"));
        click.click();

        Thread.sleep(5000);

        driver.quit();


    }
}
