package android.base;

import android.utils.ConfigUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.time.Duration;

public class BaseTest {
    protected AppiumDriverLocalService service;
    protected AndroidDriver driver;

    @BeforeMethod
    public void setup() {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(System.getenv("APPIUM_HOME") + ConfigUtils.getMainJsPath()))
                .withIPAddress(ConfigUtils.getIpAddress())
                .usingPort(Integer.parseInt(ConfigUtils.getPortNumber()))
                .withTimeout(Duration.ofSeconds(100))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid(ConfigUtils.getDeviceUdId());
        options.setDeviceName(ConfigUtils.getDeviceName());
        options.setAppPackage(ConfigUtils.getAppPackage());
        options.setAppActivity(ConfigUtils.getAppActivity());
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("settings[waitForIdleTimeout]", 0);

        driver = new AndroidDriver(service.getUrl(), options);
    }

    @AfterMethod
    public void tearDown(){
        service.stop();
    }

    private void killApp() {
        try {
            driver.terminateApp(ConfigUtils.getAppPackage());
            System.out.println("Killed app: " + ConfigUtils.getAppPackage());
        } catch (Exception e) {
            throw new RuntimeException("Failed killing the app" + e.getMessage());
        }
    }

    private void relaunchApp() {
        try {
            driver.activateApp(ConfigUtils.getAppPackage());
            System.out.println("Relaunched app: " + ConfigUtils.getAppPackage());
        } catch (Exception e) {
            throw new RuntimeException("Failed Relaunching the app" + e.getMessage());
        }
    }

    protected void restartApp(){
        killApp();
        relaunchApp();
    }
}
