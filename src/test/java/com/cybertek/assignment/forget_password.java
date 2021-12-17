package com.cybertek.assignment;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forget_password {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().setPosition(new Point(1350, 0));
        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //homeLink
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println(homeLink.getText());


        //forget PassWord Header
        WebElement forgetPassWord = driver.findElement(By.xpath("//h2"));
        System.out.println(forgetPassWord.getText());

        //e-mail Text
        WebElement e_mail = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println(e_mail.getText());

        //e-mail Input Box
        WebElement e_mail_input_box= driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println(e_mail_input_box.getText());

        //retrieve password button
        WebElement retrieve_password_button = driver.findElement(By.xpath("//button[@id='form_submit']"));
        System.out.println(retrieve_password_button.getText());

        e_mail_input_box.sendKeys("mike@smith.com");
        retrieve_password_button.click();

        Thread.sleep(3000);
        driver.quit();


        // Added to mac




    }



}
