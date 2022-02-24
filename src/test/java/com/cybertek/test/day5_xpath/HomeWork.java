package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1375,0));
        // go to amazon.com
        driver.get("http://amazon.com");
        // search for selenium
        WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("selenium");
        //click search button

        WebElement button = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        button.click();
        //verify 1-48 of 191 results for "selenium"
        WebElement ver = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/span/h1/div/div[1]/div/div/span[1]"));
        WebElement verify = driver.findElement(By.xpath("//div/span[3]"));
        String a = ver.getText()+" "+verify.getText();
        System.out.println(a);


        if (a.equals("1-48 of 191 results for \"selenium\"")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

       // Thread.sleep(5000);
        driver.quit();

    }

}


