package android.page;

import android.popups.SettingsPopup;
import android.utils.ConfigUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;

public class ProfilePage {
    //Variables
    private static ProfilePage profilePage;
    private WebDriverWait wait;
    private final By settingsIcon = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");
    private final By loginButton = By.xpath("//android.widget.TextView[@text='Log In']");

    //Constructor
    private ProfilePage(){}

    //Methods
    public static ProfilePage getInstance() {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        return profilePage;
    }
    public void clickSettingsIcon(AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsIcon)).click();
    }

    public void clickLoginButton(AndroidDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }
}
