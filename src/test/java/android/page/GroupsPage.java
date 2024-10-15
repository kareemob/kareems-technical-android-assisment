package android.page;

import android.components.BottomNavigation;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupsPage {
    //Variables
    private static GroupsPage groupsPage;
    private WebDriverWait wait;
    private final By myGroupsButton = By.xpath("//android.widget.TextView[@text='My Groups']");
    //Constructor
    private GroupsPage(){}

    //Methods

    public static GroupsPage getInstance() {
        if (groupsPage == null) {
            groupsPage = new GroupsPage();
        }
        return groupsPage;
    }

    public Boolean isMyGroupButtonDisplayed(AndroidDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myGroupsButton)).isDisplayed();
    }

}
