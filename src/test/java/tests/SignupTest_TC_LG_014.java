package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

@SuppressWarnings("unused")
public class SignupTest_TC_LG_014 extends BaseTest {
    @Test @Parameters("browser")
    public void testPageLoadTime(String browser) throws InterruptedException {
                long start = System.currentTimeMillis();
        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.jsReturnsValue("return document.readyState === ''complete''"));
        Assert.assertTrue(System.currentTimeMillis() - start < 8000, "Page load too long");
    }
}