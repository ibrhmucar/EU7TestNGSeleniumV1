package com.cybertek.test.day12_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class PropertiesTest {

    @Test

    public void test1 (){

        String browserType = ConfigurationReader.get("browser");
        WebDriver driver = WebDriverFactory.getDriver(browserType);

        String url = ConfigurationReader.get("url");
        driver.get(url);

    }

    @Test

    public void OpenBrowserWithConf() throws InterruptedException{

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.get("browser"));
        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.get("driver_username"));
        Thread.sleep(3000);
        driver.findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.get("driver_password")+Keys.ENTER);
        // driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);

        driver.close();


    }

}
