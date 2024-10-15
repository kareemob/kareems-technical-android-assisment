package android.components;

import android.page.LandingPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class BottomNavigation {
    private static BottomNavigation bottomNavigation;
    private WebDriverWait wait;
    private final By profileButton = By.xpath("//android.widget.TextView[@text='Profile' or @text='حسابك']");
    private final By eventsButton = By.xpath("//android.widget.TextView[@text='Groups']");


    //Constructor
    private BottomNavigation(){}

    //Methods

    public static BottomNavigation getInstance() {
        if (bottomNavigation == null) {
            bottomNavigation = new BottomNavigation();
        }
        return bottomNavigation;
    }
    public void navigateToProfilePage(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton)).click();
    }

    public void navigateToEventsPage(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(eventsButton)).click();
    }
}
