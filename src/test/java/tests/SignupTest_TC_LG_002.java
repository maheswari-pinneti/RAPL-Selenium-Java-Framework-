package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_002 extends BaseTest {
    @Test @Parameters("browser")
    public void testEnrollmentTextVisible(String browser) throws InterruptedException {
        SignupPage page = new SignupPage(driver); Assert.assertTrue(page.isEnrollmentTextDisplayed(), "Enrollment text not visible");
    }
}