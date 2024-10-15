package android.test;

import android.base.BaseTest;
import android.components.BottomNavigation;
import android.page.GroupsPage;
import android.page.LandingPage;
import android.page.ProfilePage;
import android.popups.LoginPopup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowsePagesTest extends BaseTest {
    @Test
    public void userShouldBeAbleToChangeLanguage() {
        // Please note that sign up is not working, So browsing to edit profile page is not doable, as well searching is not working
        LandingPage.getInstance().clickContinueButton(driver);
        LandingPage.getInstance().clickSkipButton(driver);
        BottomNavigation.getInstance().navigateToEventsPage(driver);
        Assert.assertTrue(GroupsPage.getInstance().isMyGroupButtonDisplayed(driver));
        BottomNavigation.getInstance().navigateToProfilePage(driver);
        ProfilePage.getInstance().clickLoginButton(driver);
        Assert.assertTrue(LoginPopup.getInstance().isEmailInputDisplayed(driver));
    }
}
