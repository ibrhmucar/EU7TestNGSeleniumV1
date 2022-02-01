package com.cybertek.cyTrakHW;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.Driver;
import org.bouncycastle.asn1.esf.SPuri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class calenderEventsPage {

   public calenderEventsPage() {
       PageFactory.initElements(Driver.get(), this);
   }

    @FindBy( xpath = "(//input[@type='checkbox'])[7]")
    public WebElement checkbox;

    @FindBy (xpath = "//td[contains(.,'Testers meeting')]")
    public WebElement testerMeeting;

    @FindBy (xpath = "(//div[@class='control-label'][1])[1]")
    public WebElement title;

    @FindBy (xpath = "(//div[@class='control-label'][1])[2]")
    public WebElement start;

    @FindBy (xpath = "(//div[@class='control-label'][1])[3]")
    public WebElement end;

    @FindBy (xpath = "(//div[@class='control-label'][1])[4]")
    public WebElement all_day_event;

    @FindBy (xpath = "(//div[@class='control-label'][1])[5]")
    public WebElement organizers;

  /*  @FindBy (xpath = "//div[@class='control-label'][6]")
    public WebElement guest;*/

  /*  @FindBy (xpath = "(//div[@class='control-label'][1])[6]")
    public WebElement recurrence;*/

    @FindBy (xpath = "(//div[@class='control-label'][1])[6]")
    public WebElement call;

    @FindBy (xpath = "(//span)[66]")
    public WebElement description;



    public WebElement getOptions(){

        String path = "//div[@class='btn btn-link dropdown-toggle']";

        return Driver.get().findElement(By.xpath(path));
    }


    public WebElement checkPageNumber(){

       // String path = "(//input[@value])[7]";
          String path = "//input[@value='1']";
        return Driver.get().findElement(By.xpath(path));

    }

    public WebElement checkDropDownNumber(){

       // String path = "(//a[@class='dropdown-item'])[1]";

          String path = "(//button[@data-toggle='dropdown'])[1]";

        return  Driver.get().findElement(By.xpath(path));
    }

    public int numberOfRow(){

        List<WebElement> rows = Driver.get().findElements(By.xpath("//tbody/tr[@class='grid-row']"));

        return rows.size();

    }

    public  WebElement totalNumberOf(){

        String path = "//label[@class='dib'][3]";

        return Driver.get().findElement(By.xpath(path));
    }



    public WebElement button (){

        String path = "//a[contains(.,'100')]";

        return Driver.get().findElement(By.xpath(path));

    }

}
