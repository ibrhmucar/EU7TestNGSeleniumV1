package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriveFactory {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.google.com");
        driver.close();


    }

}
