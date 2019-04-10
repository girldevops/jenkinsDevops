package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OpsLogout extends AbstractOperation{

    public OpsLogout(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }
    //------------------- Define elements ------------


    @AndroidFindBy(id = "android:id/button1")
    private static MobileElement AlertAcceptButton;
    @AndroidFindBy (id = "android:id/button2")
    private static MobileElement AlertRefuseButton;

    //-------------------click------------------------

    public static void clickOnSignOutButton(AndroidConfigClass d) {


        test.log (Status.INFO,"click On SignOut Button");
        wait.until(visibilityOf(AlertAcceptButton));
        AlertAcceptButton.click();

    }
    public static void clickOnCancelSignOutButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Cancel SignOut Button ");
        wait.until(visibilityOf(AlertRefuseButton));
        AlertRefuseButton.click();
    }


}
