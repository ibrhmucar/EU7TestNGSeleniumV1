package com.cybertek.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class homeWork {

    @Test

    public static void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://youtube.com");

        driver.quit();




    }

}
