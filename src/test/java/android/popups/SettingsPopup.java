package android.popups;

import android.components.BottomNavigation;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPopup {
    //Variables
    private static SettingsPopup settingsPopup;
    private WebDriverWait wait;
    private final By changeLanguageButton = By.xpath("//android.widget.TextView[@text='Change Language' or @text='تغيير اللغة']");
    private final By arabicLanguageButton = By.xpath("//android.widget.TextView[@text='العربية']");
    private final By okButton = By.xpath("//android.widget.TextView[@text='نعم']");

    //Constructor
    private SettingsPopup(){}

    //Methods
    public static SettingsPopup getInstance() {
        if (settingsPopup == null) {
            settingsPopup = new SettingsPopup();
        }
        return settingsPopup;
    }
    public void changeLanguage(AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeLanguageButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(arabicLanguageButton)).click();
    }

    public Boolean acceptChangingLanguageAndCheckIfLanguageChanged(AndroidDriver driver){
        boolean isOkButtonDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(okButton)).isDisplayed();
        driver.findElement(okButton).click();
        return isOkButtonDisplayed;
    }
}
