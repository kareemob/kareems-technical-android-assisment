package android.test;

import android.base.BaseTest;
import android.components.BottomNavigation;
import android.page.LandingPage;
import android.page.ProfilePage;
import android.popups.SettingsPopup;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ChangeLanguageTest extends BaseTest {
    @Test
    public void userShouldBeAbleToChangeLanguage() {
        LandingPage.getInstance().clickContinueButton(driver);
        LandingPage.getInstance().clickSkipButton(driver);
        BottomNavigation.getInstance().navigateToProfilePage(driver);
        ProfilePage.getInstance().clickSettingsIcon(driver);
        SettingsPopup.getInstance().changeLanguage(driver);
        Assert.assertTrue(SettingsPopup.getInstance().acceptChangingLanguageAndCheckIfLanguageChanged(driver));
        // Since it's a bug we need to kill and restart the app, currently the only way to check is the popup appearance or restart the app
        restartApp();
        Assert.assertTrue(LandingPage.getInstance().isTheSelectedLanguageArabic(driver));
    }
}
