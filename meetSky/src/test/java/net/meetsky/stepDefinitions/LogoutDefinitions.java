package net.meetsky.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.MeetSkyLoginPage;
import net.meetsky.pages.MeetSkyMainPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class LogoutDefinitions {

    MeetSkyLoginPage meetSkyLoginPage= new MeetSkyLoginPage();
    MeetSkyMainPage meetSkyMainPage = new MeetSkyMainPage();

    @Given("user is on the main page")
    public void user_is_on_the_main_page() {
        meetSkyLoginPage.loginPage();
        meetSkyLoginPage.validCredentialUsername();
        meetSkyLoginPage.validCredentialPassword();
        meetSkyLoginPage.clickLoginButton();
    }
    @When("user clicks on the user avatar")
    public void user_clicks_on_the_user_avatar() {
        BrowserUtils.clickWithJS(meetSkyMainPage.avatarButton);
        BrowserUtils.waitFor(5);


    }

    @When("user clicks on logout")
    public void user_clicks_on_logout() {
       meetSkyMainPage.logOutButton.click();
       BrowserUtils.waitFor(5);
    }
    @Then("user lands on login page")
    public void user_lands_on_login_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Meetsky - QA");

    }



    @When("user logs out")
    public void user_logs_out() {
        BrowserUtils.clickWithJS(meetSkyMainPage.avatarButton);
        BrowserUtils.waitFor(5);
        meetSkyMainPage.logOutButton.click();
        BrowserUtils.waitFor(5);

    }
    @Then("user should not got to home page again by clicking back")
    public void user_should_not_got_to_home_page_again_by_clicking_back() {
        Driver.getDriver().navigate().back();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Meetsky - QA");

    }

}
