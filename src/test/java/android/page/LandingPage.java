package android.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    //Variables
    private static LandingPage landingPage;
    private final By continueButton = By.xpath("//android.widget.TextView[@text='Continue' or @text='استمرار']");
    private final By skipButton = By.xpath("//android.widget.TextView[@text='تخطي' or @text='Skip']");
    private final By selectedLanguage = By.xpath("//android.widget.TextView[@text='English ']");
    private WebDriverWait wait;

    //Constructor
    private LandingPage(){}

    //Methods

    public static LandingPage getInstance() {
        if (landingPage == null) {
            landingPage = new LandingPage();
        }
        return landingPage;
    }
    public void clickContinueButton(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
    }

    public void clickSkipButton(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton)).click();
    }

    public boolean isTheSelectedLanguageArabic(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectedLanguage)).isDisplayed();
    }
}
