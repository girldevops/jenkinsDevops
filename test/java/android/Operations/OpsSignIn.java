package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class OpsSignIn extends AbstractOperation{

    public OpsSignIn(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver, 240, TimeUnit.SECONDS), this);
    }

    //------------------- Define elements ------------

    @AndroidFindBy (id = "CDMenuSignInUIButton")
    private static MobileElement CDMenuSignInButton;
    @AndroidFindBy (id = "CDSignInEmailUIText")
    private static MobileElement CDSignInEmailText;
    @AndroidFindBy (id = "CDSignInPasswordUIText")
    private static MobileElement CDSignInPassword;
    @AndroidFindBy (id = "CDSignInUIButton")
    private static MobileElement CDSignInButton;
    @AndroidFindBy (id = "CDMenuSignOutUIButton")
    private static MobileElement CDMenuSignOutButton;
    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Open on phone\"]")
    private static MobileElement UpButton;

    //---------------------clear---------------------
    public static void clearSignInEmailField(AndroidConfigClass d) {

        test.log (Status.INFO,"clear SignIn Email Field");
        CDSignInEmailText.clear();
    }

    public static void clearSignInPasswordField(AndroidConfigClass d) {

        test.log (Status.INFO,"clear SignIn Email Field");
        CDSignInPassword.clear();
    }

    //-------------------click------------------------
    public static void clickOnSignInMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On SignIn MenuButton");
        wait.until(visibilityOf(CDMenuSignInButton));
        CDMenuSignInButton.click();
    }

    public static void clickOnSignInFormButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click OnSignIn FormButton");
        CDSignInButton.click();
    }

    public static void clickOnSignOutButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On SignOut Button");
        CDMenuSignOutButton.click();
    }
    public static void clickOnUpButton (AndroidConfigClass d) {

        test.log (Status.INFO,"click On Menu berger Button");
        wait.until(visibilityOf(UpButton));
        UpButton.click();
    }
    //------------------check visibility--------------------
    public static boolean checkVisibilityOfSignInFormButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignIn Form Button");
        return CDSignInButton.isDisplayed();
    }

    public  static boolean checkVisibilityOfSignOutButton(AndroidConfigClass d) {


        test.log (Status.INFO,"check Visibility Of SignOut Button");
        return CDMenuSignOutButton.isDisplayed();
    }
    public static boolean checkVisibilityOfSignInButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignIn  Button");
        return CDMenuSignInButton.isDisplayed();
    }
    //-------------------send keys-------------------------
    public static void fillInSignInEmailField(AndroidConfigClass d, String value) {

        test.log (Status.INFO,"fillIn SignIn Email Field");
        CDSignInEmailText.clear();
        CDSignInEmailText.sendKeys(value);
    }

    public static void fillInSignInPasswordField(AndroidConfigClass d, String value) {

        test.log (Status.INFO,"fillIn SignIn Password Field");
        CDSignInPassword.clear();
        CDSignInPassword.sendKeys(value);
    }

    //--------------------Sign in---------------------------
    public static void signIn(AndroidConfigClass d, String login, String password) {


        test.log (Status.INFO,"clear SignIn Email Text");
        wait.until(visibilityOf(CDSignInEmailText));
        CDSignInEmailText.clear();

        test.log (Status.INFO,"clear SignIn Password ");
        CDSignInPassword.clear();

        test.log (Status.INFO,"fill SignIn Email Text");
        CDSignInEmailText.sendKeys(login);

        test.log (Status.INFO,"fill SignIn Password");
        CDSignInPassword.sendKeys(password);

        test.log (Status.INFO,"click SignIn Password");
        CDSignInPassword.click();
        test.log (Status.INFO,"click OnSignIn FormButton");
        CDSignInButton.click();

    }

    //---------------------Sign out--------------------------
    public static void signOut(AndroidConfigClass d) {

        //todo : refactor this page this methode must be moved to the logout page to
       // wait.until(visibilityOfElementLocated(By.id("CDMenuSignOutUIButton")));

        test.log (Status.INFO,"click on Menu SignOut Button");
        d.getDriver().findElement(By.id("CDMenuSignOutUIButton")).click();

        test.log (Status.INFO,"click on android:id/button1 ");
        wait.until(visibilityOfElementLocated(By.id("android:id/title_template")));
        d.getDriver().findElement(By.id("android:id/button1")).click();
        //wait.until(visibilityOfElementLocated(By.id("CDMenuSignInUIButton")));
    }
}
