package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_009 extends BaseTest {
    @Test @Parameters("browser")
    public void testPageTitleValid(String browser) throws InterruptedException {
        Assert.assertTrue(driver.getTitle().contains("RapL") || driver.getPageSource().contains("RapL"), "Page does not contain RapL");
    }
}