package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1375,0));
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();


        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        System.out.println(driver.findElement(By.className("h3")).getText());

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='button3()']"));
        button.click();

        Thread.sleep(5000);
        driver.close();

        ////button[@onclick='button3()']
        //"/html/body/div/div/div/div/button[3]"

    }
}
