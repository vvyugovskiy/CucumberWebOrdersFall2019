package com.weborders.step_definitions;

import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("Scenario name: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();

    }

    @Before("@scenario_1")
    public void specialSetup(Scenario scenario) {
        System.out.println("Test scenario :: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void specialTearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image, "image/png", scenario.getName());
        }
        BrowserUtilities.wait(3);
        Driver.closeDriver();
    }
}
