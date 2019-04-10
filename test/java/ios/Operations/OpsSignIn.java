package ios.Operations;

import io.appium.java_client.MobileElement;
import ios.iOSConfigClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by m.doudouch on 05/09/2017.
 */
public class OpsSignIn {

    public static MobileElement signInBtn, loginEmailTxt, loginPassWordTxt, loginConnectBtn,
            disconnectBtn, rightBtnAlert, menuActualView;

    static String email  = "dev@lk.com";
    static String password = "test";

    static String facebookEmail = "";
    static String faceookPassword = "";

    public static void clickSignInBtnHomeScreen(iOSConfigClass d){
        WebDriverWait wait = new WebDriverWait(d.getDriver(), 15);
        wait.until(presenceOfElementLocated(By.name("ALHSSignInBtn")));
        signInBtn = (MobileElement) d.getDriver().findElement(By.name("ALHSSignInBtn"));
        signInBtn.click();
    }

    public static void emailAccountSignIn (iOSConfigClass d){
        WebDriverWait wait = new WebDriverWait(d.getDriver(), 15);
        wait.until(presenceOfElementLocated(By.name("ALLoginEmailTxtField")));

        //Fill in the text fields and sign-in veiw Function.
        fillInSignInFields(d, email, password);

        loginConnectBtn = (MobileElement) d.getDriver().findElement(By.name("ALLoginBtnConnect"));
        loginConnectBtn.click();

    }

    public static void fillInSignInFields (iOSConfigClass d, String lg, String pw){
        loginEmailTxt = (MobileElement) d.getDriver().findElement(By.name("ALLoginEmailTxtField"));
        loginPassWordTxt = (MobileElement) d.getDriver().findElement(By.name("ALLoginPWTxtField"));

        loginEmailTxt.clear();
        loginPassWordTxt.clear();

        loginEmailTxt.sendKeys(lg);
        loginPassWordTxt.sendKeys(pw);

    }

    //Menu listing:
    public enum ActualMenuView {
        NEWSSTAND,

        SEARCH,

        READER,

        LIBRARY

    }

    public static void signOut (iOSConfigClass d){

        //TEST WAITING:
        WebDriverWait waitBeforeSignInOut = new WebDriverWait(d.getDriver(), 15);
        waitBeforeSignInOut.until(presenceOfElementLocated(By.name("ALNewsstandUIButtonMenu")));

        //Which view is displayed:
        String viewName = GenericClass.findView(d);

        ActualMenuView amv = ActualMenuView.valueOf(viewName);

        switch (amv){
            case NEWSSTAND:
                break;

            case READER:
                //close the reader:
                d.getDriver().findElement(By.name("ALMySpaceButtonMenu")).click();

                //redirect to NewsStand:
                WebDriverWait wait = new WebDriverWait(d.getDriver(),10);
                wait.until(presenceOfElementLocated(By.name("ALMenuKiosque")));
                d.getDriver().findElement(By.name("ALMenuKiosque")).click();
                break;

            case SEARCH:
                //redirect to NewsStand:
                d.getDriver().findElement(By.name("ALMenuKiosque")).click();
                break;
        }


        GenericClass.openNewsStandMenu(d);

        WebDriverWait wait = new WebDriverWait(d.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.name("ALEditerMonProfilBtn")));

        //Swipe Down:
        GenericClass.swipeDown(d, "ALdisconnectBtn");

        disconnectBtn = (MobileElement) d.getDriver().findElement(By.name("ALdisconnectBtn"));
        disconnectBtn.click();

        wait.until(presenceOfElementLocated(By.name("ALMessageBoxUIButtonRight")));
        rightBtnAlert = (MobileElement) d.getDriver().findElement(By.name("ALMessageBoxUIButtonRight"));
        rightBtnAlert.click();

    }

    /*---------------------clear---------------------*/
    public static void clearSignInEmailField(iOSConfigClass d){
        d.getDriver().findElement(By.id("ALLoginEmailTxtField")).clear();
    }

    public static void clearSignInPasswordField(iOSConfigClass d){
        d.getDriver().findElement(By.id("ALLoginUITextFieldPassword")).clear();

    }
}
