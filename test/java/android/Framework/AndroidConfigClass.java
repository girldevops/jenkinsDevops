package android.Framework;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by FatimaZahra on 27/01/2017.
 */
public class AndroidConfigClass {

    //File appDir = new File("lekioskAndroid/app/build/outputs/apk/lekiosk/preprod/");
  
   // File app = new File(appDir, "app-lekiosk-preprod.apk");
    String apkpath="/Users/Shared/Jenkins/Home/workspace/apk/lekioskAndroid/app/build/outputs/apk/lekiosk/preprod/app-lekiosk-preprod.apk";
    File app = new File(apkpath);
    static AndroidDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public AndroidConfigClass() {
        capabilities.setCapability("deviceName", "Nexus_6");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("clearSystemFiles", true);
        capabilities.setCapability("automationName", "appium");

        URL url = null;

        try {
            url = new URL("http://localhost:4000/wd/hub");
        } catch (MalformedURLException e) {
            System.out.print ("can 't start appium on local host ");
            e.printStackTrace();
        }

        driver = new AndroidDriver( capabilities);
        System.out.printf(driver.toString());

    }

    public AndroidDriver getDriver() {
        return driver;
    }
}
