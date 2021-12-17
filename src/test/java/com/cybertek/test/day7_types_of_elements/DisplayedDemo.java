package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));
        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(),"is not Displayed");

        WebElement starButton = driver.findElement(By.xpath(("(//button[@class='btn btn-primary'])[1]")));
        starButton.click();

        Thread.sleep(6000);

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed(),"is Displayed");
        usernameInput.sendKeys("mike smith");





    }



}
