package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_007 extends BaseTest {
    @Test @Parameters("browser")
    public void testTermsLinkOpensTermsPage(String browser) throws InterruptedException {
                SignupPage page = new SignupPage(driver);
        String main = driver.getWindowHandle();
        page.clickTermsAndSwitchToNewTab();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("terms") || driver.getPageSource().contains("Terms"), "Terms page not opened");
        page.closeCurrentTabAndSwitchBack(main);
    }
}