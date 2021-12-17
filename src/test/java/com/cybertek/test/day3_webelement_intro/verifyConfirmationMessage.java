package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().setPosition(new Point(1200,0));

        //enter any email
        String expectedemail = "mike@mike.com";
        WebElement mail = driver.findElement(By.name("email"));
        mail.sendKeys(expectedemail);


        //verify that confirmation message says "Your e-mail's been sent!"
        String actualemails = mail.getAttribute("value");
        System.out.println("actualemails = " + actualemails);

        
       if(expectedemail.equals(actualemails)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        //send mail adress
        WebElement check = driver.findElement(By.id("form_submit"));
        check.click();

        //Verify

        WebElement message = driver.findElement(By.name("confirmation_message"));
        String value = message.getText();

        if(value.equals("Your e-mail's been sent!")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.quit();

    }

}
