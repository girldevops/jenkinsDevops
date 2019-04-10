package android.Pages;

import android.Framework.ExtentReportManager;
import android.Framework.GenericOperations;
import android.Operations.OpsSignUp;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SignUpTest extends AbstractTest{


    @BeforeClass
    public static void beforeClass() {
        OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding
        a = ExtentReportManager.GetExtent();
    }
    @Test
    public void test_01_GraphicControll() throws Exception {

        test = a.createTest("SignUp :test_01_GraphicControll ", "As a user, I want to register on the app");

        OpsSignUp.clickOnUpButton(d);
        OpsSignUp.clickOnSignUpButton(d);
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfFacebookSignUpButton(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpSubTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpEmailField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordConfirmationField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpByEmailButton(d));

    }


    @Test
    public void test_02_CreateAccountWithEmptyFields() throws Exception {
        test = a.createTest("SignUp :test_02_CreateAccountWithEmptyFields ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.clickOnSignUpEmailButton(d);
        OpsSignUp.clickOnAlertAcceptButton(d);
    }

  @Test
    public void test_03_SingUpWithWrongEmail() throws Exception {
        test = a.createTest("SignUp :test_03_SingUpWithWrongEmail ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.fillInSignUpEmailField(d, "wrong@mail");
        OpsSignUp.fillInSignUpPasswordField(d, "1111");
        OpsSignUp.fillInSignUpPasswordConfirmationField(d, "1111");
        d.getDriver().hideKeyboard();
        OpsSignUp.clickOnSignUpEmailButton(d);
        Assert.assertEquals("Invalid email address", OpsSignUp.getAlertTitle(d));
        OpsSignUp.clickOnAlertAcceptButton(d);
    }

    @Test
    public void test_04_ValidEmailShortPw() throws Exception {
        test = a.createTest("SignUp :test_04_ValidEmailShortPw ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.fillInSignUpEmailField(d, "correct@mail.com");
        OpsSignUp.fillInSignUpPasswordField(d, "11");
        OpsSignUp.fillInSignUpPasswordConfirmationField(d, "11");
        d.getDriver().hideKeyboard();
        OpsSignUp.clickOnSignUpEmailButton(d);
        Assert.assertEquals("The password is too short", OpsSignUp.getAlertTitle(d));
        OpsSignUp.clickOnAlertAcceptButton(d);
    }

    @Test
    public void test_05_ValidEmailDifferentPasswords() throws Exception {
        test = a.createTest("SignUp :test_05_ValidEmailDifferentPasswords ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.fillInSignUpEmailField(d, "correct@mail.com");
        OpsSignUp.fillInSignUpPasswordField(d, "1111");
        OpsSignUp.fillInSignUpPasswordConfirmationField(d, "1112");
        d.getDriver().hideKeyboard();
        OpsSignUp.clickOnSignUpEmailButton(d);
        Assert.assertEquals("Passwords do not match", OpsSignUp.getAlertTitle(d));
        OpsSignUp.clickOnAlertAcceptButton(d);
    }

    @Test
    public void test_06_SignUpWithExistingAccount() throws Exception {
        test = a.createTest("SignUp :test_06_SignUpWithExistingAccount ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.fillInSignUpEmailField(d, "m.doudouch@lekiosque.fr");
        OpsSignUp.fillInSignUpPasswordField(d, "1111");
        OpsSignUp.fillInSignUpPasswordConfirmationField(d, "1111");
        d.getDriver().hideKeyboard();
        OpsSignUp.clickOnSignUpEmailButton(d);
        Assert.assertEquals("This account already exists", OpsSignUp.getAlertTitle(d));
        OpsSignUp.clickOnAlertRefuseButton(d);
    }


    @Test
    public void test_07_SignUpWithValidCredentials() throws Exception {
        test = a.createTest("SignUp :test_07_SignUpWithValidCredentials ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.signUp(d, GenericOperations.emailAccount(), "1111");
      //  Assert.assertTrue(OpsNewsstand.checkVisibilityOfCarrousel(d)); //to find the element
        OpsSignUp.clickOnImageButtonClose(d);
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpTitleLabel(d));
    }

    @Test

    public void test_08_SignUpWithValidCredentials3() throws Exception {
        test = a.createTest("SignUp :test_08_SignUpWithValidCredentials3 ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.signUp(d, GenericOperations.emailAccount(), "1111");
      //  Assert.assertTrue(OpsNewsstand.checkVisibilityOfCarrousel(d));
        OpsSignUp.clickOnChangeAdressMail(d);
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpTitleLabel(d));
    }

    @Test
    public void test_09_SignUpWithValidCredentials4() throws Exception {
        test = a.createTest("SignUp :test_09_SignUpWithValidCredentials4 ",  "As a user, I want to sign up with an Email on the app");

        OpsSignUp.signUp(d, GenericOperations.emailAccount(), "1111");
      //Assert.assertTrue(OpsNewsstand.checkVisibilityOfCarrousel(d));//to find the element
        OpsSignUp.clickOnResendMail(d);
      //Assert.assertTrue(OpsSignUp.checkVisibilityOftextdisplay(d)); resource id not found
    }

//__________________________
    /*
    @Test
    public void testHSignUpWithFacbook() throws Exception{

        //If you need a facebook test account, use this link:
        //https://lekiosk.atlassian.net/wiki/display/QA/Creating+and+managing+Facebook+test+users

        d.getDriver().findElement(By.id("CDSignUpFacebookUIButton")).click();
        wait.until(visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]" +
                "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                "/android.webkit.WebView[1]")));
        d.getDriver().findElement(By.xpath("//android.widget.LinearLayout[1]" +
                "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                "/android.webkit.WebView[1]/android.view.View[3]" +
                "/android.widget.EditText[1]")).sendKeys("ymunyhr_baoson_1475246842@tfbnw.net");
        d.getDriver().findElement(By.xpath("//android.widget.LinearLayout[1]" +
                "/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]" +
                "/android.widget.LinearLayout[1]/android.webkit.WebView[1]" +
                "/android.webkit.WebView[1]/android.view.View[3]" +
                "/android.widget.EditText[2]")).sendKeys("lekiosk1234");
        d.getDriver().findElement(By.id("Connexion")).click();
        wait.until(visibilityOfElementLocated(By.id("OK")));
        d.getDriver().findElement(By.id("OK")).click();
        wait.until(visibilityOfElementLocated(By.id("CDSignUpCompleted")));
        d.getDriver().findElement(By.id("CDSignUpCompleted")).click();
        wait.until(visibilityOfElementLocated(By.id("android:id/up")));
    }

    // todo to verify this : this
    // quit must be in the final test in the test suite

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


