package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenBrowser {

    public static void main(String[] args) {

       WebDriverManager.chromedriver().setup();


       WebDriver driver = new ChromeDriver();

       

        driver.get("http://amazon.com");
        System.out.println(driver.getTitle());
        if(driver.getTitle().equals("Amazon.com. Spend less. Smile more.")){
            driver.navigate().to("http://youtube.com");
            System.out.println(driver.getTitle());
        }else {
            driver.close();
        }

        if (driver.getTitle().equals("YouTube")) {
            driver.navigate().to("http://amazon.com");
            driver.navigate().refresh();
            } else {
                driver.close();
            }

            driver.close();
    }


}
