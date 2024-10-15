package android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {
    public static Properties prop = readProp();
    private static Properties readProp() {
        Properties prop = new Properties();
        try {
            FileInputStream is = new FileInputStream("src/test/resources/res/production.properties");
            prop.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return prop;
    }
    public static String getAppPackage() {
        return prop.getProperty("apkPackage");
    }
    public static String getAppActivity() {
        return prop.getProperty("apkActivity");
    }
    public static File getMainJsPath() {
        return new File(prop.getProperty("mainJsPath"));
    }
    public static String getDeviceUdId() {
        return prop.getProperty("deviceUdId");
    }
    public static String getDeviceName() {
        return prop.getProperty("deviceName");
    }
    public static String getPortNumber(){
        return prop.getProperty("portNumber");
    }

    public static String getIpAddress(){
        return prop.getProperty("ipAddress");
    }
}
