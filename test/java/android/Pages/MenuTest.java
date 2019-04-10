package android.Pages;

import android.Framework.ExtentReportManager;
import android.Operations.OpsMenu;
import android.Operations.OpsSignIn;
import android.Operations.OpsSignUp;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;






/* This test class is to find every element of the Menu Drawer for Connected & non connected users */

public class MenuTest extends AbstractTest{

    @BeforeClass
    public static void beforeClass() {
       // OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding
        a = ExtentReportManager.GetExtent();
    }

    //there is no anonymous user anymore
    //Anonymous User:
/*
    @Test
    public void testAMenuUserInfoNonConnected() throws Exception {
        OpsSignUp.clickOnUpButton(d);
        Assert.assertTrue(OpsMenu.checkVisibilityOfUserName(d));
        Assert.assertEquals("Anonyme", OpsMenu.getUserName(d));
        Assert.assertEquals("0 crédit", OpsMenu.getCreditsAmount(d));
    }
*/

    @Test(enabled=true)
    public void test_03_MenuSignInButton() throws Exception {

        //Bouton Connexion
        test = a.createTest("Menu: test_03_MenuSignInButton ", "");
        Assert.assertTrue(OpsMenu.checkVisibilityOfSignInMenuButton(d));
    }

    @Test(enabled=true)
    public void test_04_MenuSignUpButton() throws Exception {

        //Bouton Inscription
        test = a.createTest("Menu: test_04_MenuSignUpButton ", "");
        Assert.assertTrue(OpsMenu.checkVisibilityOfSignUpMenuButton(d));
    }

    @Test(enabled=true)
    public void test_02_MenuMessageToLogged() throws Exception {

        // Message must be displayed to try to log
        test = a.createTest("Menu: test_02_MenuMessageToLogged ", "");
        Assert.assertEquals("Login", OpsMenu.getMessageToLogged(d));
    }
    @Test(enabled=true)
    public void test_05_MenuUserIcon() throws Exception {

        //image anonymous user
        test = a.createTest("Menu: test_05_MenuUserIcon ", "");
        Assert.assertTrue(OpsMenu.checkVisibilityOfUserIcon(d));
    }
    @Test(enabled=true)
    public void test_01_MenuSettingsCountryoffers() throws Exception {

        test = a.createTest("Menu: test_01_MenuSettingsCountryoffers ", "");
        //Bloc Aide & Paramètres, Store:
        OpsSignUp.clickOnUpButton(d);
        Assert.assertTrue(OpsMenu.checkVisibilityOfSettingsMenuButton(d));
        Assert.assertTrue(OpsMenu.checkVisibilityOfCountryMenuButton(d));
        // TODO: Create resource id  MenuOurOffers to this checkVisibilityOfOffersMenuButton
        //Assert.assertTrue(OpsMenu.checkVisibilityOfOffersMenuButton(d));
    }
    @Test(enabled=true)
    public void test_06_MenuSignInPage() throws Exception {

        test = a.createTest("Menu: test_06_MenuSignInPage ", "");
        //Bouton Connexion
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsMenu.clickBackfromLogin (d);

    }

    @Test(enabled=true)
    public void test_07_MenuSignUpPage() throws Exception {

        test = a.createTest("Menu: test_07_MenuSignUpPage ", "");
        //Bouton Inscription
        OpsSignUp.clickOnSignUpButton (d);
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfFacebookSignUpButton(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpSubTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpEmailField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordConfirmationField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpByEmailButton(d));
    }
    //todo : to be developed
    @Test(enabled=false)
    public void test_08_MenuOurOffersPageVisibility() throws Exception {

        test = a.createTest("Menu: test_08_MenuOurOffersPageVisibility ", "");

    }
    @Test(enabled=false)
    public void test_09_MenuSettingsPageVisibility() throws Exception {

        test = a.createTest("Menu: test_09_MenuSettingsPageVisibility ", "");

    }
    @Test(enabled=true)
    public void test_10_MenuStorePageVisibility() throws Exception {

        test = a.createTest("Menu: test_10_MenuStorePageVisibility ", "");
        OpsMenu.clickBackfromRegister (d);
    }
    //TODO  TEST must passed
    // this test must be ignored
    @Test(enabled=false)

    public void test_11_MenuUserInfoLoggedIn() {

        test = a.createTest("Menu: test_11_MenuUserInfoLoggedIn", "");
        //Pré-Condition: Log in with valid account
        //Clear any text if needed
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsSignIn.signIn(d, "test@menu.fr", "1111");

        //Close the Offer popin.

//        OpsMenu.closeOfferInvitationPopin(d);

        Assert.assertEquals("test@menu.fr", OpsMenu.getUserName(d));
        Assert.assertEquals("4 credits", OpsMenu.getCreditsAmount(d));
        Assert.assertTrue(OpsMenu.checkVisibilityOfSignOutMenuButton(d));
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            test.log(Status.FAIL, "Test Case Failed is "+result.getName());
            test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
            //-------------To add it in the extent report-------------

            String screenshotPath = null;
            try {
                screenshotPath = r.getScreenshot(d.getDriver (), result.getName());
                test.fail("Test step fail as shown in the screenshot below: ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace ();
            }
            //---------------------------------------------------------

        }else if(result.getStatus() == ITestResult.SUCCESS){
            test.log(Status.PASS, "Test Case success is "+result.getName());
        }else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
        }
    }
    @AfterClass
    public static void tearDown(){

        d.getDriver().resetApp ();
        a.flush();
    }


}
