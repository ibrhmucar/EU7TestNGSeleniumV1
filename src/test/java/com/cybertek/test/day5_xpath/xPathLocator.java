package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.*;

public class xPathLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().setPosition(new Point(1375,0));
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button[2]")); //     //*[@*='button3()']   //button[@onclick='button1()']
        button.click();                                                                                        //button=[text='Button 1']
                                                                                                               //button=[.='Button 1']

        Thread.sleep(3000);

        driver.quit();





    }
}
