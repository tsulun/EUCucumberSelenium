package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    //driver.findElement(By.id("prependedInput"));
    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })
    public WebElement usernameinput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement loginBtn;

    @FindBy(linkText = "Forgot your password?")
    public  WebElement forgotYourPasswordButton;

    @FindBy(xpath = "//*[text()='Invalid user name or password.']")
    public WebElement invalidCredentialsMessage;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement checkBoxRem;

    @FindBy(css = "#remember_me")
    public WebElement checkBoxRem2;

    @FindBy(xpath = "//*[text()='Remember me on this computer']")
    public WebElement rememberMeText;

    public void login(String username, String password) {
        usernameinput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsDriver() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        usernameinput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsAStoreManager() {
        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");
        usernameinput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsASalesManager() {
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");
        usernameinput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
