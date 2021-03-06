package net.meetsky.stepDefinitions;


import net.meetsky.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

        @Before
        public void setupScenario(){

        }
        @After
        public void teardownScenario(Scenario scenario){
            if(scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
            Driver.closeDriver();
        }
    }

