package android.Operations;
import android.Framework.AndroidConfigClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class OpsOursOffers extends AbstractOperation{

    public OpsOursOffers(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }

    //------------------- Define elements ----------------------------
    @AndroidFindBy(id = "id1")
    private static MobileElement Offers ;
    @AndroidFindBy(id = "fr.lekiosque:id/newStand_offer_background_imageView")
    private static MobileElement Bloc1Id ;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.ListView/android.widget.LinearLayout[2]")
    private static MobileElement Bloc2Id ;
    @AndroidFindBy(id = "fr.lekiosque:id/newsStand_catalog_foreground_relativeLayout")
    private static MobileElement Bloc3Id ;
    @AndroidFindBy(id = "4BlocId")
    private static MobileElement Bloc4Id ;
    @AndroidFindBy(id = "fr.lekiosque:id/newsStand_offer_button_title")
    private static MobileElement TryButton ;
    @AndroidFindBy(id = "fr.lekiosque:id/newsStand_offer_secure_message")
    private static MobileElement SecurePaymentBar ;
    @AndroidFindBy(id = "android:id/alertTitle")
    private static MobileElement PopupLekiosKAccount ;
    @AndroidFindBy(id = "OnOurOffersBarAction")
    private static MobileElement OnOurOffersBarAction ;
    @AndroidFindBy (id = "android:id/button2")
    private static MobileElement AlertLoginButton;
    @AndroidFindBy (id = "android:id/button1")
    private static MobileElement AlertRegisterButton;
    @AndroidFindBy (id = "android:id/action_bar_title")
    private static MobileElement BackFromBarAction;
    @AndroidFindBy (id = "fr.lekiosque:id/newsStand_catalog_button_title")
    private static MobileElement ViewMagazinesButton;
    @AndroidFindBy (id = "EligibleMagazinesListview")
    private static MobileElement EligibleMagazinesListview ;


    //----------------------click on ----------------------------------
    public static void clickOnOurOffersOnMenu(AndroidConfigClass d) {

        Offers.click();
    }
    public static void clickOnTryfButton(AndroidConfigClass d) {

        TryButton.click();
    }
    public static void clickOnOurOffersBarAction(AndroidConfigClass d) {

        OnOurOffersBarAction.click();
    }

    public static void clickOnLogin(AndroidConfigClass d) {

        AlertLoginButton.click();
    }

    public static void clickOnRegister(AndroidConfigClass d) {

        AlertRegisterButton.click();
    }
    public static void clickOnbackBarAction(AndroidConfigClass d) {

       d.getDriver ().tap (1,1,1,1);

    }
    public static void clickOnViewMagazines(AndroidConfigClass d) {

        ViewMagazinesButton.click();
    }

    //----------------------check visibility---------------------------
    public static boolean checkVisibilityOfBloc1(AndroidConfigClass d) {

        return Bloc1Id.isDisplayed();
    }
    public static boolean checkVisibilityOfBloc2(AndroidConfigClass d) {

        return Bloc2Id.isDisplayed();
    }
    public static boolean checkVisibilityOfBloc3(AndroidConfigClass d) {

       return Bloc3Id.isDisplayed();
    }
    public static boolean checkVisibilityOfBloc4(AndroidConfigClass d) {

        return Bloc3Id.isDisplayed();
    }
    public static boolean checkVisibilityOfTryfButton(AndroidConfigClass d) {

        return TryButton.isDisplayed();
    }
    public static boolean checkVisibilityOfSecurePaymentBar(AndroidConfigClass d) {

        return SecurePaymentBar.isDisplayed();
    }
    public static boolean checkVisibilityOfPopupLeKioskAccount(AndroidConfigClass d) {

        return PopupLekiosKAccount.isDisplayed();
    }
    public static boolean checkVisibilityOfOffersMenuButton(AndroidConfigClass d) {

        return Offers.isDisplayed();
    }
    public static boolean checkVisibilityOfEligiblemagsList(AndroidConfigClass d) {

        return EligibleMagazinesListview.isDisplayed();
    }
    //----------------------scroll down-----------------------------------------------

    public static void scrollDownOurOffers (AndroidConfigClass d) {

        int x = Bloc2Id.getLocation().getX();
        int y = Bloc2Id.getLocation().getY();

        TouchAction action = new TouchAction(d.getDriver ());
        action.press(x,y).moveTo(x+90,y).release().perform();




    }


}
