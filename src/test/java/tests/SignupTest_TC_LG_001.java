package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest_TC_LG_001 extends BaseTest {

    @Test
    public void testWelcomePageLoads() {
        // Wait for the welcome heading to be visible
        By welcomeHeading = By.tagName("h1"); // Adjust selector as needed
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeHeading));
        
        boolean isDisplayed = driver.findElement(welcomeHeading).isDisplayed();
        Assert.assertTrue(isDisplayed, "Welcome heading not displayed");
    }

    @Test
    public void testPageTitle() {
        String expectedTitle = "RAPL"; // Adjust as needed
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
            "Title does not contain expected text. Actual: " + actualTitle);
    }

    @Test
    public void testSignupLinkPresent() {
        By signupLink = By.linkText("Sign up"); // Adjust selector
        wait.until(ExpectedConditions.elementToBeClickable(signupLink));
        Assert.assertTrue(driver.findElement(signupLink).isDisplayed(), 
            "Signup link not displayed");
    }
}