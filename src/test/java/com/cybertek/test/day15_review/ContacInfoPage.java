package com.cybertek.test.day15_review;

import com.cybertek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContacInfoPage extends BasePage {

    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement fullName;

    @FindBy(css = "a.phone")
    public WebElement phoneNumber;

    @FindBy(css = "a.email")
    public WebElement email;


}
