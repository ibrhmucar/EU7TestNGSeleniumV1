package com.cybertek.test.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
      driver =  WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }



    @Test

    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("button size : " + buttons.size());

        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        for (WebElement button : buttons) {
            System.out.println(button.getText());
            System.out.println(button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"Verify button are displayed");
        }


        buttons.get(1).click();



    }





}
