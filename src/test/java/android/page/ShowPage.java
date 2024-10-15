package android.page;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ShowPage {
    //Variables
    private static final By resumeButton = By.xpath("//android.widget.LinearLayout[@resource-id=\"net.mbc.shahid.debug:id/watch_button_container\"]");
    //AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"net.mbc.shahid.debug:id/player_view\")");
            //By.id("net.mbc.shahid.debug:id/player_view");
            //By.xpath("(//android.widget.LinearLayout[@resource-id=\"net.mbc.shahid.debug:id/watch_button_container\"])[2]");
    private static final By watchNowButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"net.mbc.shahid.debug:id/img_watch_arrow\").instance(1)");
    private static final By playerBackButton = By.id("net.mbc.shahid.debug:id/ib_back");
    private static final By playForworld = By.id("net.mbc.shahid.debug:id/fast_forward");
    private static final By backButton = By.id("net.mbc.shahid.debug:id/ib_player_back");
    private static final By stati = By.id("net.mbc.shahid.debug:id/txt_genre");
    private static final By player = By.xpath("//android.widget.FrameLayout[@resource-id=\"net.mbc.shahid.debug:id/exo_subtitles\"]/android.view.View");
    private static final By movieName = By.id("net.mbc.shahid.debug:id/show_title");
    private static final By loader = By.id("net.mbc.shahid.debug:id/loading_layout");
    private static final By playerView = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"net.mbc.shahid.debug:id/player_view\")");
    private static final By newForYouCarousel = By.id("net.mbc.shahid.debug:id/text_title");
    private static final By movieNameCw = By.id("net.mbc.shahid.debug:id/text_show_movie_title");
    private static final By heroView = By.id("net.mbc.shahid.debug:id/hero_gradient");
    private static final By moreButton = By.id("net.mbc.shahid.debug:id/img_btn_more");
    private static final By gridShow = By.className("android.widget.GridView");

    //Methods
    public static String getMovieName(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(heroView));

        WebElement element = driver.findElement(heroView);

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 1.0

        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieName));
        String name = driver.findElement(movieName).getText();
        System.out.println(name);
        return name;
    }
    public static String playMovie(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.findElement(resumeButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(stati));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(playerView)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(playForworld));
        for (int i=0; i<30; i++) {
            driver.findElement(playForworld).click();
        }
        //wait.until(ExpectedConditions.visibilityOfElementLocated(playerView)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(playerBackButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(newForYouCarousel));
        WebElement element = driver.findElement(gridShow);
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 1.0
        ));
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreButton));
        driver.findElement(moreButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieNameCw));
        return driver.findElement(movieNameCw).getAttribute("text");
    }
}
