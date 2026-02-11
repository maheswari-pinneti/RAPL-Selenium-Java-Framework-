package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.List;

public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h3[contains(text(),'Welcome to RapL')]") private WebElement welcomeHeading;
    @FindBy(xpath = "//h3[contains(text(),'Find and fix knowledge gaps')]") private WebElement slide2Heading;
    @FindBy(xpath = "//h3[contains(text(),'Earn points, Badges and Rewards')]") private WebElement slide3Heading;
    @FindBy(xpath = "//h3[contains(text(),'Reduce Errors, Mistakes and Delays')]") private WebElement slide4Heading;
    @FindBy(xpath = "//h3[contains(text(),'RapL is here to assist you')]") private WebElement slide5Heading;
    @FindBy(xpath = "//*[contains(text(),'To create a new account in RapL please provide your details and enroll.')]") private WebElement enrollmentText;
    @FindBy(linkText = "Terms") private WebElement termsLink;
    @FindBy(linkText = "Privacy Policy") private WebElement privacyLink;
    @FindBy(xpath = "//*[contains(text(),'No internet connection')]") private WebElement offlineBanner;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isWelcomeHeadingDisplayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(welcomeHeading)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isSlide2Displayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(slide2Heading)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isSlide3Displayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(slide3Heading)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isSlide4Displayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(slide4Heading)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isSlide5Displayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(slide5Heading)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isEnrollmentTextDisplayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(enrollmentText)).isDisplayed(); } catch (Exception e) { return false; } }
    public boolean isOfflineBannerDisplayed() {
        try { return wait.until(ExpectedConditions.visibilityOf(offlineBanner)).isDisplayed(); } catch (Exception e) { return false; } }

    // ---------- CORRECT CAROUSEL NAVIGATION – USES <li> INDICATORS ----------
    public void clickCarouselIndicator(int index) {
        try {
            String selector = ".carousel-indicators li";
            List<WebElement> indicators = driver.findElements(org.openqa.selenium.By.cssSelector(selector));
            if (indicators.size() > index) {
                wait.until(ExpectedConditions.elementToBeClickable(indicators.get(index))).click();
                Thread.sleep(800);
            }
        } catch (Exception e) { System.out.println("Could not click indicator " + index); }
    }

    @SuppressWarnings("unused")
    public void clickTermsAndSwitchToNewTab() {
        String main = driver.getWindowHandle();
        Set<String> before = driver.getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(termsLink)).click();
        wait.until(d -> driver.getWindowHandles().size() > before.size());
        Set<String> after = driver.getWindowHandles();
        after.removeAll(before);
        driver.switchTo().window(after.iterator().next());
    }

    @SuppressWarnings("unused")
    public void clickPrivacyAndSwitchToNewTab() {
        String main = driver.getWindowHandle();
        Set<String> before = driver.getWindowHandles();
        wait.until(ExpectedConditions.elementToBeClickable(privacyLink)).click();
        wait.until(d -> driver.getWindowHandles().size() > before.size());
        Set<String> after = driver.getWindowHandles();
        after.removeAll(before);
        driver.switchTo().window(after.iterator().next());
    }

    public void closeCurrentTabAndSwitchBack(String mainWindow) {
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    public boolean areCarouselIndicatorsPresent() {
        String[] selectors = {".carousel-indicators li", ".carousel-indicators button", ".slider-indicators", ".dots li", "[data-slide-to]", ".slideshow-indicators"};
        for (String sel : selectors) { try { if (driver.findElements(org.openqa.selenium.By.cssSelector(sel)).size() > 0) return true; } catch (Exception ignored) {} }
        return false;
    }
}