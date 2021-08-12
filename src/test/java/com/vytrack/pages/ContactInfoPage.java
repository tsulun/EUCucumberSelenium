package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{
    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement fullname;
    @FindBy(css = "span.inline-actions-element_wrapper>a.phone")
    public WebElement phone;
    @FindBy(css = "span.inline-actions-element_wrapper>a.email")
    public WebElement email;
}
