package ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by m.doudouch on 10/01/2017.
 */
public class iOSConfigClass {

    static IOSDriver driver;
    String appiumVersion   = "1.6.5";
    String deviceName      = "HADA";
    String platformeName   = "iOS";
    String platformVersion = "9.3";

    String appPath         = "/Users/m.doudouch/Library/Developer/Xcode/DerivedData/LeKiosque-hbetmkpdniaetxdgldmzrsyajzyz/Build/Products/Beta-iphonesimulator/LeKiosque.app";
    String bundleId        = "lekioskworld";
    String eUDID           = "6E1262D4-302B-460A-9911-9C426F8DFD6B";
    String automationName  = AutomationName.IOS_XCUI_TEST;


    public void setup(){

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.APPIUM_VERSION, appiumVersion);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,platformeName);
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        dc.setCapability(MobileCapabilityType.APP,appPath);
        dc.setCapability("bundleId",bundleId);
        dc.setCapability(MobileCapabilityType.UDID, eUDID);
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        dc.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            if (driver == null)
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public IOSDriver getDriver() {
        return driver;
    }

    public iOSConfigClass() {
        super();
            setup();
    }
}
