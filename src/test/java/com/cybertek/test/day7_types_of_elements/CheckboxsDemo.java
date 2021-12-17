package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxsDemo {

    @Test
        public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/checkboxes");

        Thread.sleep(2000);
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox 1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox 2 is selected");

        Thread.sleep(2000);
        checkbox1.click();

        Thread.sleep(2000);
        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox 1 is not selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox 2 is selected");

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());


        driver.quit();


    }
}
