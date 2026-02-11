package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_011 extends BaseTest {
    @Test @Parameters("browser")
    public void testOfflineBannerHiddenByDefault(String browser) throws InterruptedException {
        SignupPage page = new SignupPage(driver); Assert.assertFalse(page.isOfflineBannerDisplayed(), "Offline banner visible when online");
    }
}