package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test

    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1350,0));

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.xpath("//*[@*='blue']"));
        WebElement redRadioBtn  = driver.findElement(By.id("red"));

        Assert.assertTrue(blueRadioBtn.isSelected(),"verify that blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"verify red is not selected");

    /*    if(blueRadioBtn.isSelected() && !redRadioBtn.isSelected()){
            System.out.println("Blue Radio Bttn is selected and Red Radio Bttn is not selected");
        }else{
            System.out.println("If statement not work :)");
        }
    */

        Thread.sleep(2000);

        redRadioBtn.click();


        Assert.assertFalse(blueRadioBtn.isSelected(),"verify that blue is selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"verify red is not selected");


        driver.quit();

    }



}
