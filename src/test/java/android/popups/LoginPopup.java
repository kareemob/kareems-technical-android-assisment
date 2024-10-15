package android.popups;

import android.page.ProfilePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPopup {
    //Variables
    private static LoginPopup loginPopup;
    private WebDriverWait wait;
    private final By emailInput = By.xpath("//android.widget.EditText[@text='Email *']");
    private final By closeIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]");

    //Constructor
    private LoginPopup(){}

    //Methods
    public static LoginPopup getInstance() {
        if (loginPopup == null) {
            loginPopup = new LoginPopup();
        }
        return loginPopup;
    }

    public Boolean isEmailInputDisplayed(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).isDisplayed();
    }

    public void closePopup(AndroidDriver driver){
        driver.findElement(closeIcon).click();
    }
}
