package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by FatimaZahra on 19/06/2017.
 */
public class OpsMenu extends AbstractOperation {

    public OpsMenu(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }

    //------------------- Define elements ------------

    @AndroidFindBy(id = "CDOfferInvitationUIButtoncloseBtn1")
    private static MobileElement CDOfferInvitationButtonClose;
    @AndroidFindBy(id = "CDMenuUserName")
    private static MobileElement CDUserName ;
    @AndroidFindBy(id = "Reader")
    private static MobileElement Reader;
    //todo : find this element
    @AndroidFindBy(id = "@+id/menu_button_offer")
    private static MobileElement Offers ;
    @AndroidFindBy(id = "MenuSettingsButton")
    private static MobileElement MenuSettingsButton;
    @AndroidFindBy(id = "MenuCountryButton")
    private static MobileElement MenuCountryButton;
    @AndroidFindBy(id = "CDMenuSignInUIButton")
    private static MobileElement CDMenuSignInButton;
    @AndroidFindBy(id = "CDMenuSignOutUIButton")
    private static MobileElement CDMenuSignOutButton;
    @AndroidFindBy(id = "CDMenuSignUpUIButton")
    private static MobileElement CDMenuSignIUpButton ;
    @AndroidFindBy(id = "fr.lekiosque:id/carouselItemBackgroundImageView")
    private static MobileElement UserIcon ;
    @AndroidFindBy(id = "fr.lekiosque:id/menu_textview_email")
    private static MobileElement UserNameEmail;
    @AndroidFindBy(id = "MenuUserNameTextView")
    private static MobileElement MessageToLogged;
    @AndroidFindBy(id = "fr.lekiosque:id/menu_textview_credits")
    private static MobileElement CreditsAmount;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private static MobileElement BackLoginButton;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private static MobileElement BackRegisterButton;



    //---------------------------click-----------------------------------
    public static void closeOfferInvitationPopin(AndroidConfigClass d) {

        test.log (Status.INFO,"close Offer Invitation Popin");
        CDOfferInvitationButtonClose.click();
    }
    public static void clickBackfromLogin(AndroidConfigClass d) {

        test.log (Status.INFO,"click Back from Login");
        BackLoginButton.click();
    }
    public static void clickBackfromRegister(AndroidConfigClass d) {

        test.log (Status.INFO,"click Back from Register");
        BackRegisterButton.click();
    }
    //---------------------------check visibility------------------------
    public static boolean checkVisibilityOfUserName(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of User Name");
        return d.getDriver().findElement(By.id("CDMenuUserName")).isDisplayed();
    }


    public static boolean checkVisibilityOfReaderMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Reader Menu Button");
        return Reader.isDisplayed();
    }

    public static boolean checkVisibilityOfOffersMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Offers Menu Button");
        return Offers.isDisplayed();
    }

    public static boolean checkVisibilityOfSettingsMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Country Menu Button");
        return MenuSettingsButton.isDisplayed();
    }

    public static boolean checkVisibilityOfCountryMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Country Menu Button");
        return MenuCountryButton.isDisplayed();
    }

    public static boolean checkVisibilityOfSignInMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignIn Menu Button");
        return CDMenuSignInButton.isDisplayed();
    }

    public static boolean checkVisibilityOfSignUpMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignUp Menu Button");
        return CDMenuSignIUpButton.isDisplayed();
    }

    public static boolean checkVisibilityOfSignOutMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of SignOut Menu Button");
        return CDMenuSignOutButton.isDisplayed();
    }

    public static boolean checkVisibilityOfUserIcon(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of UserIcon");
        return UserIcon.isDisplayed();
    }

    //--------------------------get text------------------------------------
    public static String getUserName(AndroidConfigClass d) {

        return UserNameEmail.getText();
    }

    public static String getCreditsAmount(AndroidConfigClass d) {

        return CreditsAmount.getText();
    }
    public static String getMessageToLogged(AndroidConfigClass d) {

        return MessageToLogged.getText();
    }


}
