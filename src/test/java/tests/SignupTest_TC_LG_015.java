package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_015 extends BaseTest {
    @Test @Parameters("browser")
    public void testCrossBrowserCompatibility(String browser) throws InterruptedException {
        SignupPage page = new SignupPage(driver); Thread.sleep(2000); Assert.assertTrue(page.isWelcomeHeadingDisplayed(), "Browser: " + browser + " failed");
    }
}