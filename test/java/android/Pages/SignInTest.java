package android.Pages;

import android.Framework.AndroidConfigClass;
import android.Framework.ExtentReportManager;
import android.Operations.OpsSignIn;
import android.Operations.OpsSignUp;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * Created by FatimaZahra on 31/01/2017.
 */

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SignInTest extends AbstractTest{

    @BeforeClass
    public static void beforeClass() {
        OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding
        a = ExtentReportManager.GetExtent();
    }
    @Test
    public void test_01_AccessSignInView() throws Exception {
        test = a.createTest("SignIn: test_01_AccessSignInView", "");
        OpsSignIn.clickOnUpButton(d);
        OpsSignIn.clickOnSignInMenuButton(d);
    }

    @Test
    public void test_02_LoginWithEmptyFields() throws Exception {
        test = a.createTest("SignIn: test_02_LoginWithEmptyFields", "");
        OpsSignIn.clickOnSignInFormButton(d);
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignInFormButton(d));
    }

    @Test
    public void test_03_LoginWithIncorrectCredentials() throws Exception {
        test = a.createTest("SignIn: test_03_LoginWithIncorrectCredentials", "");
        OpsSignIn.signIn(d, "wrongLogin", "wrongPassword");
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignInFormButton(d));
    }

    //test login with valid ID
//TODO  TEST must passed
    @Test(enabled=true)
    public void test_05_LoginWithValidID() throws Exception {
        test = a.createTest("SignIn: test_05_LoginWithValidID", "");
        OpsSignIn.clickOnSignInMenuButton (d);
        OpsSignIn.signIn(d, "FEDD", "1234");
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignOutButton(d));
        OpsSignIn.signOut(d);

    }

    //test login with valid email
//TODO  TEST must passed
    @Test(enabled=true)
    public void test_04_LoginWithValidEmail() throws Exception {
        test = a.createTest("SignIn: test_04_LoginWithValidEmail", "");
        OpsSignIn.signIn(d, "testLogin.test@lekiosque.fr", "1234");
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignOutButton(d));
        OpsSignIn.signOut(d);

    }

    /*
            @Test
            public void testELoginWithFacebook() throws Exception{
                //Disconnect the actual connected account
                wait.until(visibilityOfElementLocated(By.id("android:id/up")));
                wait.until(visibilityOfElementLocated(By.id("CDMenuDisconnectButton")));
                d.getDriver().findElement(By.id("CDMenuDisconnectButton")).click();
                wait.until(visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
                        "/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]" +
                        "/android.widget.Button[2]")));
                d.getDriver().findElement(By.xpath("//android.widget.FrameLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]" +
                        "/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]" +
                        "/android.widget.Button[2]")).click();

                //Start connecting
                d.getDriver().findElement(By.id("CDMenuSignInUIButton")).click();
                wait.until(visibilityOfElementLocated(By.id("CDSignInFacebookUIButton")));
                d.getDriver().findElement(By.id("CDSignInFacebookUIButton")).click();
                wait.until(visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                        "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                        "/android.webkit.WebView[1]")));
                d.getDriver().findElement(By.xpath("//android.widget.LinearLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                        "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                        "/android.webkit.WebView[1]/android.view.View[3]" +
                        "/android.widget.EditText[1]")).sendKeys("xucbvmg_chaistein_1475246879@tfbnw.net");
                d.getDriver().findElement(By.xpath("//android.widget.LinearLayout[1]" +
                        "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                        "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                        "/android.webkit.WebView[1]/android.view.View[3]" +
                        "/android.widget.EditText[2]")).sendKeys("lekiosk1234");
                d.getDriver().findElement(By.id("Connexion")).click();
                wait.until(visibilityOfElementLocated(By.id("OK")));
                d.getDriver().findElement(By.id("OK")).click();
                //Close the offer view
                wait.until(visibilityOfElementLocated(By.id("CDOfferInvitationUIButtoncloseBtn")));
                if (d.getDriver().findElement(By.id("CDOfferInvitationUIButtoncloseBtn")).isDisplayed() == true) {
                    d.getDriver().findElement(By.id("CDOfferInvitationUIButtoncloseBtn")).click();
                }
                wait.until(visibilityOfElementLocated(By.id("android:id/up")));
            }
    */
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
