package net.meetsky.pages;

import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class MeetSkyLoginPage {

    public MeetSkyLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy (xpath="//*[@id=\"user\"]")
    public WebElement username;

    @FindBy (id="password")
    public WebElement password;

    @FindBy (xpath="//input[@value='Log in']")
    public WebElement loginButton;

    @FindBy (xpath="//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;

   @FindBy (css = "a[class='toggle-password']")
   public WebElement passwordEyeIcon;

    @FindBy (xpath = "//a[@id='lost-password']")
    public WebElement forgotPasswordLink;

    @FindBy (xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordButton;





    public void loginPage() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }












    public void validCredentialUsername(){
        WebElement usernamePlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        usernamePlaceholder.sendKeys(ConfigurationReader.getProperty("username"));

    }

    public void validCredentialPassword(){
        WebElement passwordPlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordPlaceholder.sendKeys(ConfigurationReader.getProperty("password"));
    }

  public void clickLoginButton(){
      WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@id='submit-form']"));
       loginButton.click();

    }

    public void invalidUsernameCredentials(){
        WebElement usernamePlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='user']"));
        usernamePlaceholder.sendKeys("username");

    }

    public void invalidPasswordCredentials(){
        WebElement passwordPlaceholder = Driver.getDriver().findElement(By.xpath("//input[@id='password']"));
        passwordPlaceholder.sendKeys("password");
    }




}

