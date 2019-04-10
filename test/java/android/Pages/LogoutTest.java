package android.Pages;

import android.Framework.ExtentReportManager;
import android.Operations.OpsLogout;
import android.Operations.OpsNewsstand;
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


/* This test class is to test Logout feature   */

public class LogoutTest extends AbstractTest{


    @BeforeClass
    public static void beforeClass() {
      //  OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding to test
        a = ExtentReportManager.GetExtent();

    }

    //TODO  TEST must passed
    @Test(enabled=true)
    public void test_01_VisiblityOfSignOutview() throws Exception {

        test = a.createTest("Logout :test_01_VisiblityOfSignOutview", "As a user, I want to");
        OpsSignUp.clickOnUpButton(d);
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsSignIn.signIn(d, "testLogin.test@lekiosque.fr", "1234");
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignOutButton(d));
        OpsSignIn.clickOnSignOutButton(d);
        OpsLogout.clickOnSignOutButton(d);

    }
    //TODO  TEST must passed
    @Test(enabled=true)
    public void test_02_Logout() throws Exception {

        test = a.createTest("Logout :test_02_Logout", "As a user, I want to");
       // todo : to remove still i can't close the pop up
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsSignIn.signIn(d, "testLogin.test@lekiosque.fr", "1234");
        OpsSignIn.clickOnSignOutButton(d);
        OpsLogout.clickOnSignOutButton(d);
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignInButton(d));
    }
    //TODO  TEST must passed
    @Test(enabled=true)
    public void test_03_CancelLogout() throws Exception {

        test = a.createTest(" Logout :test_03_CancelLogout", "As a user, I want to");
        // todo : to remove still i can't close the pop up
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsSignIn.signIn(d, "testLogin.test@lekiosque.fr", "1234");
        OpsSignIn.clickOnSignOutButton(d);
        OpsLogout.clickOnCancelSignOutButton(d);
        Assert.assertTrue(OpsSignIn.checkVisibilityOfSignOutButton(d));
        OpsSignIn.signOut (d);//logout to return to  disconnected state
    }
    @AfterMethod
    public void getResult(ITestResult result){

        if(result.getStatus() == ITestResult.FAILURE){

        // -------------Mark build as failed--------------------------
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
