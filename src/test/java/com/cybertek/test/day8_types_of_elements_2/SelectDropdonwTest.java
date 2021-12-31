package com.cybertek.test.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdonwTest {
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

    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));
        Select stateDropDown = new Select(dropdownElement);

        List<WebElement> options = stateDropDown.getOptions();
        System.out.println("options.size() = " + options.size());

     /*   for (WebElement option : options) {
            System.out.println(option.getText());
    }
    */
        String expectedOption = "Select a State";
        String actualOutput = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOutput,expectedOption, "verify first selection");

        Thread.sleep(2000);
        stateDropDown.selectByVisibleText("Virginia");

        expectedOption= "Virginia";
        actualOutput = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOutput,expectedOption, "verify first selection");

        Thread.sleep(2000);
        stateDropDown.selectByIndex(51);

        expectedOption= "Wyoming";
        actualOutput = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOutput,expectedOption, "verify first selection");

        Thread.sleep(2000);
        stateDropDown.selectByValue("TX");

        expectedOption= "Texas";
        actualOutput = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOutput,expectedOption, "verify first selection");


        }




    }

