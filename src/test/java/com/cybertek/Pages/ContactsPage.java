package com.cybertek.Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    //We don't need to create constructor and use PageFactory class here
    //Since we are extending from basePage


    //If you are trying to come up dynamic Xpath you cannot use @FindBy
    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;

    public WebElement getContactEmail(String email) {
        String emailXpath = "//td[contains(text(),'" + email + "')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(emailXpath));

    }

}

