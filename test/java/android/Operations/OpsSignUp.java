package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by FatimaZahra on 15/06/2017.
 */
public class OpsSignUp extends AbstractOperation{
    public OpsSignUp(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }
    //------------------- Define elements ------------

    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Open on phone\"]")
    private static MobileElement UpButton;
    @AndroidFindBy (id = "CDMenuSignUpUIButton")
    private static MobileElement CDMenuSignIUpButton;
    @AndroidFindBy (id = "CDSignUpEmailUIButton")
    private static MobileElement CDSignIUpEmailButton;
    @AndroidFindBy (id = "android:id/button1")
    private static MobileElement AlertAcceptButton;
    @AndroidFindBy (id = "android:id/button2")
    private static MobileElement AlertRefuseButton;
    @AndroidFindBy (id = "fr.lekiosque:id/imgButton_close")
    private static MobileElement CloseAlmostThere ;
    @AndroidFindBy (id = "fr.lekiosque:id/buttonOne")
    private static MobileElement SendAgainButton ;
    @AndroidFindBy (id = "fr.lekiosque:id/buttonTwo")
    private static MobileElement ChangeEmail ;
    @AndroidFindBy (id = "CDSignUpEmailUIText")
    private static MobileElement CDSignUpEmailText  ;
    @AndroidFindBy (id = "CDSignUpPasswordUIText")
    private static MobileElement CDSignUpPassword ;
    @AndroidFindBy (id = "CDSignUpPasswordConfirmUIText")
    private static MobileElement CDSignUpPasswordConfirm ;
    @AndroidFindBy (id = "fr.lekiosque:id/buttonConnectFacebook")
    private static MobileElement CDSignUpFacebook ;
    @AndroidFindBy (id = "CDSignUpContinueButton")
    private static MobileElement CDSignUpContinueBtton ;
    @AndroidFindBy (id = "android:id/alertTitle")
    private static MobileElement AlertTitleInvalidMail ;




    //-------------------------click------------------------------
    public static void skipAppUpdateAlert(AndroidConfigClass d) {
        if(!d.getDriver().findElements(By.id("android:id/alertTitle")).isEmpty()) {
            wait.until(visibilityOf(AlertTitleInvalidMail));
            d.getDriver().pressKeyCode(AndroidKeyCode.BACK);;
        }
    }
    public static void skipSimplified  (AndroidConfigClass d) {
        wait.until(visibilityOfElementLocated(By.id("@+id/close_button")));
        d.getDriver().findElement(By.id("@+id/close_button")).click();//close the tool tip

    }

    public static void clickOnUpButton (AndroidConfigClass d) {

        test.log (Status.INFO,"click On UpButton");
        wait.until(visibilityOf(UpButton));
        UpButton.click();
    }
    public static void clickOnSignUpButton (AndroidConfigClass d) {

        test.log (Status.INFO,"click On SignUp Button");
        CDMenuSignIUpButton.click();

    }
    public static void clickOnSignUpEmailButton (AndroidConfigClass d) {

        test.log (Status.INFO,"click On SignIUp Email Button");
        CDSignIUpEmailButton.click();

    }
    public static void clickOnAlertAcceptButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Alert Accept Button");
        AlertAcceptButton.click();
    }
    public static void clickOnAlertRefuseButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Alert Refuse Button");
        AlertRefuseButton.click();
    }
    public static void clickOnImageButtonClose(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Close Almost There");
        CloseAlmostThere.click();
    }
    public static void clickOnResendMail(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Send Again Button");
        SendAgainButton.click();
    }
    public static void clickOnChangeAdressMail(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Change Email");
        ChangeEmail.click();
    }

    //----------------Send keys---------------------
    public static void fillInSignUpEmailField (AndroidConfigClass d, String value) {

        test.log (Status.INFO,"clear SignUp Email Text ");
        CDSignUpEmailText.clear();

        test.log (Status.INFO,"fill the Email");
        CDSignUpEmailText.sendKeys(value);
    }
    public static void fillInSignUpPasswordField (AndroidConfigClass d, String value) {

        test.log (Status.INFO,"clear Password");
        CDSignUpPassword.clear();

        test.log (Status.INFO,"fill Password ");
        CDSignUpPassword.sendKeys(value);
    }
    public static void fillInSignUpPasswordConfirmationField (AndroidConfigClass d, String value) {

        test.log (Status.INFO,"click On  Password Confirm ");
        CDSignUpPasswordConfirm.clear();

        test.log (Status.INFO,"fill   Password Confirm ");
        CDSignUpPasswordConfirm.sendKeys(value);
    }
    //----------------check visibility------------------
    public static boolean checkVisibilityOfSignUpTitleLabel (AndroidConfigClass d) {

        test.log (Status.INFO," check Visibility Of Signp Title Label ");
        return d.getDriver().findElement(By.id("fr.lekiosque:id/toolbar_title")).isDisplayed();
    }
    public static boolean checkVisibilityOfFacebookSignUpButton (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Facebook SignUp Button");
        return CDSignUpFacebook.isDisplayed();
    }
    public static boolean checkVisibilityOfSignUpSubTitleLabel (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp SubTitle Label");
        return d.getDriver().findElement(By.id("fr.lekiosque:id/textViewOr")).isDisplayed();
    }
    public static boolean checkVisibilityOfSignUpEmailField (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp Email Field");
        return CDSignUpEmailText.isDisplayed();
    }
    public static boolean checkVisibilityOfSignUpPasswordField (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp Password Field");
        return CDSignUpPassword.isDisplayed();
    }
    public static boolean checkVisibilityOfSignUpPasswordConfirmationField (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp Password Confirmation Field");
        return CDSignUpPasswordConfirm.isDisplayed();
    }
    public static boolean checkVisibilityOfSignUpByEmailButton (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp By Email Button");
        return CDSignIUpEmailButton.isDisplayed();
    }
    public static boolean checkVisibilityOftextdisplay (AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of text display");
        return d.getDriver().findElement(By.id("@+id/textViewText")).isDisplayed();
    }


    //-----------------clear---------------------------------------------
    public static void clearSignUpEmailField (AndroidConfigClass d) {

        CDSignUpEmailText.clear();
        test.log (Status.INFO,"clear SignUp Email Field");
    }
    public static void clearSignUpPasswordField (AndroidConfigClass d) {

        test.log (Status.INFO,"clear SignUp Password Field");
        CDSignUpPassword.clear();
    }
    public static void clearSignUpPasswordConfirmationField (AndroidConfigClass d) {

        test.log (Status.INFO,"clear SignUp Password Confirmation Field");
        CDSignUpPasswordConfirm.clear();
    }
    //-----------------------get text------------------------------------
    public static String getAlertTitle(AndroidConfigClass d) {

        test.log (Status.INFO," getText  Alert Title Invalid Mail ");
        return AlertTitleInvalidMail.getText();
        }
    public static String getMessageText(AndroidConfigClass d) {

        test.log (Status.INFO," getMessageText  ubscription alert invalid passwords title ");

        return d.getDriver().findElement(By.id("subscription_alert_invalid_passwords_title")).getText();
    }



    //----------------------sign up---------------------------------
    public static void signUp(AndroidConfigClass d , String email, String password) {

        wait.until(visibilityOf(CDSignIUpEmailButton));
        CDSignUpEmailText.clear();
        CDSignUpEmailText.sendKeys(email);
        CDSignUpPassword.clear();
        CDSignUpPassword.sendKeys(password);
        CDSignUpPasswordConfirm.clear();
        CDSignUpPasswordConfirm.sendKeys(password);
        d.getDriver().hideKeyboard();
        CDSignIUpEmailButton.click();
        if(!(d.getDriver().findElements(By.id("CDSignUpEmailUIButton"))).isEmpty()) {
        CDSignUpContinueBtton.click();
        }


    }



}
