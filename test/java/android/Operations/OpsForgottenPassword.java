package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class OpsForgottenPassword extends AbstractOperation{

    public OpsForgottenPassword(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }

    //------------------- Define elements ------------

    @AndroidFindBy(id = "CDSignInPasswordForgotUIButton")
    private static MobileElement CDSignInForgottenPwdButton ;
    @AndroidFindBy(id = "CDPwdForgottenResetUIButton")
    private static MobileElement CDPwdForgottenResetButton ;
    @AndroidFindBy(id = "CDPwdForgottenCloseUIButton")
    private static MobileElement CDPwdForgottenCloseButton ;
    @AndroidFindBy(id = "CDPwdForgottenEmailUIText")
    private static MobileElement CDPwdForgottenEmailText ;

    //----------------------------click-------------------------------
    public static void clickForgottenPasswordLink(AndroidConfigClass d) {

        test.log (Status.INFO,"click Forgotten Password Link");
        CDSignInForgottenPwdButton.click();
    }

    public static void clickOnResetPasswordButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click OnReset Password Button");
        CDPwdForgottenResetButton.click();
    }

    //----------------------check visibility---------------------------
    public static boolean checkVisibilityOfPasswordResetButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Password Reset Button");
        return CDPwdForgottenResetButton.isDisplayed();
    }

    public static boolean checkVisibilityOfPasswordResetConfirmation(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Password Reset Confirmation");
        return CDPwdForgottenCloseButton.isDisplayed();
    }

    //----------------------send keys---------------------------------
    public static void fillResetPasswordEmailField(AndroidConfigClass d, String email) {

        test.log (Status.INFO,"fill Reset Password Email Field");
        CDPwdForgottenEmailText.clear();
        CDPwdForgottenEmailText.sendKeys(email);
    }
}