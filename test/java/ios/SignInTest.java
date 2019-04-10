package ios;

import ios.Operations.OpsSignIn;
import org.junit.AfterClass;

import org.junit.Test;


/**
 * Created by m.doudouch on 29/08/2017.
 */


public class SignInTest {

    static iOSConfigClass d = new iOSConfigClass();

    @Test
    public void testAEmailSignInFromHomeScreen(){

        OpsSignIn.clickSignInBtnHomeScreen(d);
        OpsSignIn.emailAccountSignIn(d);
        OpsSignIn.signOut(d);

    }

    @Test
    public void testBEmailSignInFromSettingsMenu(){

    }


    @AfterClass
    public static void tearDown(){
        d.getDriver().quit();
    }

}
