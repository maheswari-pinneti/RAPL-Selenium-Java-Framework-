package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_005 extends BaseTest {
    @Test @Parameters("browser")
    public void testCarouselSlide4Visible(String browser) throws InterruptedException {
        SignupPage page = new SignupPage(driver); page.clickCarouselIndicator(3); Assert.assertTrue(page.isSlide4Displayed(), "Slide 4 heading not found");
    }
}