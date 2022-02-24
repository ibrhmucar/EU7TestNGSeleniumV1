package com.cybertek.test.day15_review;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.test.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test

    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("username" + username);
        extentLogger.info("password" + password);
        extentLogger.info("Login as a Sales Manager");
        loginPage.login(username,password);

        extentLogger.info("Navigate to --> Customer > Contacts");
        new DashboardPage().navigateToModule("Customers","Contacts");

        extentLogger.info("Click on mbrackstone9@example.com");
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();


        ContacInfoPage contacInfoPage = new ContacInfoPage();
        contacInfoPage.waitUntilLoaderScreenDisappear();



        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contacInfoPage.fullName.getText();

        extentLogger.info("Verify full name is " + expectedFullName);
        Assert.assertEquals(actualFullName,expectedFullName,"Verify fullName");

        Assert.assertEquals(contacInfoPage.email.getText(),"mbrackstone9@example.com", "verify email");
        extentLogger.info("Verify email is mbrackstone9@example.com");

        Assert.assertEquals(contacInfoPage.phoneNumber.getText(),"+18982323434","verify phone ");
        extentLogger.info("Verify phone number is +18982323434");

        extentLogger.pass("PASSED");



    }






}
