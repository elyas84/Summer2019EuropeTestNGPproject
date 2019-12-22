package com.cybertek.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

        @FindBy(css="h1.user-name")
        public WebElement fullName;
        @FindBy(xpath = "//a[@class='email']")
        public WebElement email;
        @FindBy (xpath = "//a[@class='phone']")
        public WebElement phone;

    }
