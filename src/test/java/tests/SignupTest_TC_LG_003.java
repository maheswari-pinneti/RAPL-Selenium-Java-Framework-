package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_003 extends BaseTest {
    @Test @Parameters("browser")
    public void testCarouselSlide2Visible(String browser) throws InterruptedException {
        SignupPage page = new SignupPage(driver); page.clickCarouselIndicator(1); Assert.assertTrue(page.isSlide2Displayed(), "Slide 2 heading not found");
    }
}