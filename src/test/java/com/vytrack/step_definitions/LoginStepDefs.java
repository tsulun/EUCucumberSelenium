package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Locale;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(3);
     String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("verify","Dashboard",actualTitle);
        // assert ( message , expected, actual )
    }
    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsASalesManager();
    }
    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsAStoreManager();
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String usertype) {
        the_user_is_on_the_login_page();
        System.out.println("usertype = " + usertype);
        LoginPage loginPage = new LoginPage();
        switch (usertype.toLowerCase(Locale.ROOT)){
            case "driver":
                loginPage.loginAsDriver();
                break;
            case "store manager":
                loginPage.loginAsAStoreManager();
                break;
            case "sales manager":
                loginPage.loginAsAStoreManager();
                break;
        }
    }
    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String string, String string2) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(string,string2);
    }

    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {
        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.invalidCredentialsMessage.isDisplayed());
    }

    @Then("User should see the password in bullet signs")
    public void user_should_see_the_password_in_bullet_signs() {
        LoginPage loginPage = new LoginPage();
       Assert.assertEquals("verify password box contains password as default","Password",loginPage.passwordInput.getAttribute("placeholder"));
    }

    @Then("User can see and use an option link like \"forgot password\" on the login page in order to successfully reset the password")
    public void user_can_see_use_an_option_link_like_forgot_password_on_the_login_page() {
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.forgotYourPasswordButton.isDisplayed());
        Assert.assertTrue(loginPage.forgotYourPasswordButton.isEnabled());
        loginPage.forgotYourPasswordButton.click();
        Assert.assertEquals("verify user navigate to reset request page","Forgot Password",Driver.get().getTitle());

    }
    @When("User clicks on remember me box")
    public void User_clicks_on_remember_me_box() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForClickablility(loginPage.checkBoxRem,5);
        loginPage.checkBoxRem.click();
    }
    @Then("User can see an option link like remember me on the login page")
    public void User_can_see_an_option_link_like_remember_me_on_the_login_page() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(2);
        Assert.assertTrue("verify option link like remember me is visible ",loginPage.rememberMeText.isDisplayed());

    }
    @Then("User can click an option link like remember me on the login page")
    public void User_can_click_an_option_link_like_remember_me_on_the_login_page() {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(2);
        Assert.assertTrue("verify option link like remember me is intractable",loginPage.checkBoxRem2.isSelected());
    }



}
