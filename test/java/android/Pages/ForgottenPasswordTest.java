package android.Pages;

import android.Framework.ExtentReportManager;
import android.Operations.OpsForgottenPassword;
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

public class ForgottenPasswordTest extends AbstractTest {

    @BeforeClass
    public static void beforeClass() {
       // OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding
        a = ExtentReportManager.GetExtent();
    }

    @Test
    public void test_01_ForgottenPasswordView() throws Exception {

        test = a.createTest("Forgotten Password :test_01_ForgottenPasswordView", "As a user, I want to");
        OpsSignUp.clickOnUpButton(d);
        OpsSignIn.clickOnSignInMenuButton(d);
        OpsForgottenPassword.clickForgottenPasswordLink(d);
        //Visibility test should be added
        Assert.assertTrue(OpsForgottenPassword.checkVisibilityOfPasswordResetButton(d));

    }

    @Test
    //Should raise an error when the email field is empty
    public void test_02_ResetPasswordWithEmptyEmailField() throws Exception {

        test = a.createTest(" Forgotten Password :test_02_ResetPasswordWithEmptyEmailField ", "As a user, I want to");
        OpsForgottenPassword.clickOnResetPasswordButton(d); //Password reset button
        Assert.assertTrue(OpsForgottenPassword.checkVisibilityOfPasswordResetButton(d));
    }

    @Test
    //Should raise an error when the ID is given instead of the email
    public void test_03_ResetPasswordWithID() throws Exception {

        test = a.createTest(" Forgotten Password :test_03_ResetPasswordWithID ", "As a user, I want to");
        OpsForgottenPassword.fillResetPasswordEmailField(d, "YIEH");
        OpsForgottenPassword.clickOnResetPasswordButton(d); //Password reset button
        Assert.assertTrue(OpsForgottenPassword.checkVisibilityOfPasswordResetButton(d));
    }

    @Test
    //Should raise an error when we provide a unexisting email
    public void test_04_ResetPasswordWithUnexistingEmail() throws Exception {

        test = a.createTest(" Forgotten Password :test_04_ResetPasswordWithUnexistingEmail ", "As a user, I want to");
        OpsForgottenPassword.fillResetPasswordEmailField(d, "unexisting@email.com"); //email field
        OpsForgottenPassword.clickOnResetPasswordButton(d); //Password reset button
        Assert.assertTrue(OpsForgottenPassword.checkVisibilityOfPasswordResetButton(d));
    }

    @Test
    //Reset password correctly with a valid email
    public void test_05_ResetPasswordWithValidEmail() throws Exception {

        test = a.createTest(" Forgotten Password : test_05_ResetPasswordWithValidEmail", "As a user, I want to");
        OpsForgottenPassword.fillResetPasswordEmailField(d, "testMobile1.test@lekiosque.fr"); //email field
        OpsForgottenPassword.clickOnResetPasswordButton(d); //Password reset button
        Assert.assertTrue(OpsForgottenPassword.checkVisibilityOfPasswordResetConfirmation(d)); //Close button of confirmation page
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

