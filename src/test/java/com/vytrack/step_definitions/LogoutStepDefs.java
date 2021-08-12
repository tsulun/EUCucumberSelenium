package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs {
    @Then("the user should be able to logout")
    public void the_user_should_be_able_to_logout() {
        DashboardPage  dashboardPage = new DashboardPage();
        dashboardPage.logOut();
        Assert.assertEquals("verify the user log out successfully","Login", Driver.get().getTitle());

    }


}
