package net.meetsky.stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import net.meetsky.pages.MeetSkyLoginPage;
import net.meetsky.pages.MeetSkyLoginPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginDefinitions {

    MeetSkyLoginPage meetSkyLoginPage = new MeetSkyLoginPage();



    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        meetSkyLoginPage.loginPage();

    }

    @When("User enters valid username")
    public void user_enters_valid_username() {
        meetSkyLoginPage.validCredentialUsername();

    }

    @And("User enters valid password")
    public void user_enters_valid_password() {
        meetSkyLoginPage.validCredentialPassword();
    }

    @And("User should be able to click login button")
    public void user_should_be_able_to_click_login_button() {
        BrowserUtils.clickWithJS(meetSkyLoginPage.loginButton);

    }

    @Then("User should land on homepage")
    public void user_should_land_on_homepage() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Files - Meetsky - QA");

    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        meetSkyLoginPage.invalidUsernameCredentials();
    }

    @Then("User should see Wrong username or password message")
    public void user_should_see_something_message() {
        Assert.assertTrue(meetSkyLoginPage.errorMessage.isDisplayed());

    }

    @When("User enters invalid password")
    public void user_enters_invalid_password() {
        meetSkyLoginPage.invalidPasswordCredentials();

    }

    @When("User leaves username placeholder empty")
    public void user_leaves_username_placeholder_empty() {
        WebElement usernamePlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        usernamePlaceholder.click();


    }

    @Then("User should see Please fill out this field message in username box")
    public void user_should_see_please_fill_out_this_field_message_in_username_box() {
        String message = meetSkyLoginPage.username.getAttribute("validationMessage");
        Assert.assertEquals("Please fill in this field.", message);

    }

    @When("User leaves password placeholder empty")
    public void user_leaves_password_placeholder_empty() {
        WebElement passwordPlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordPlaceholder.click();

    }

    @Then("User should see Please fill out this field message in password box")
    public void user_should_see_message() {
        String message = meetSkyLoginPage.password.getAttribute("validationMessage");
        Assert.assertEquals("Please fill in this field.", message);
    }

    @Then("User should see password text in the form of dots")
    public void user_should_see_password_text_in_the_form_of_dots() {
        Assert.assertEquals(meetSkyLoginPage.password.getAttribute("type"), "password");
    }

    @When("User clicks on the eye icon inside the password placeholder")
    public void user_clicks_on_the_eye_icon_inside_the_password_placeholder() {
        meetSkyLoginPage.passwordEyeIcon.click();


    }

    @Then("User should be able to view the password text explicitly")
    public void user_should_be_able_to_view_the_password_text_explicitly() {
        Assert.assertEquals(meetSkyLoginPage.password.getAttribute("type"), "text");

    }

    @When("User clicks on forgot password link")
    public void user_clicks_on_forgot_password_link() {
        meetSkyLoginPage.forgotPasswordLink.click();

    }

    @When("User lands on next page")
    public void user_lands_on_next_page() {
        Assert.assertEquals(Driver.getDriver().getTitle(), "Meetsky - QA");


    }

    @Then("User can see reset password button")
    public void user_can_see_reset_password_button() {
        Assert.assertTrue(meetSkyLoginPage.resetPasswordButton.isDisplayed());


    }

    @Then("User can see username placeholder")
    public void user_can_see_username_placeholder() {

        Assert.assertTrue(meetSkyLoginPage.username.isDisplayed());


    }

    @Then("User can see password placeholder")
    public void user_can_see_password_placeholder() {
        Assert.assertTrue(meetSkyLoginPage.password.isDisplayed());

    }

}