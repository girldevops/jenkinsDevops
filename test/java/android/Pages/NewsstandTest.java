package android.Pages;

import android.Framework.ExtentReportManager;
import android.Operations.OpsNewsstand;
import android.Operations.OpsSignUp;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.android.Connection;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class NewsstandTest extends AbstractTest{


    @BeforeClass
    public static void beforeClass() {
       // OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding
        a = ExtentReportManager.GetExtent();

    }
    //---------------------------anonymous user ----------------------------------------
    //Check that blocks are visible
    @Test(enabled = false)
    public void test_03_CheckBlocksVisibility1() throws Exception {

        test = a.createTest("Newsstand: test_03_CheckBlocksVisibility", "");

        //close Simplified Navigation tooltip
        //Todo get tooltip close button id
        //OpsSignUp.skipSimplified(d);
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfCarrousel(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandHorizontalListView(d));
       // Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandCategoriesButton(d));
    }
    @Test
    public void test_02_ClickCarrousel() throws Exception {
        test = a.createTest("Newsstand: test_02_ClickCarrousel", "");
        //todo : to be dev in fiche product page

    }

    @Test
    public void test_01_UpButton() throws Exception {
        test = a.createTest("Newsstand: test_01_UpButton", "");

       OpsSignUp.clickOnUpButton(d);


    }
    @Test
    public void test_04_searchtap() throws Exception {
        test = a.createTest("Newsstand: test_04_searchtap", "");
        //todo : to be dev in search   page

    }

//TODO: Handle dynamic ids
    //Change category and check that blocks are visible
    @Test(enabled = false)
    public void test_05_Categories() throws Exception {

        test = a.createTest("Newsstand: test_05_Categories", "");

        OpsNewsstand.clickOnNewsstandMenuCategoriesButton(d);
        //todo : get ids of Category News ,Women & Men
/*      Assert.assertTrue(OpsNewsstand.checkVisibilityOfCategoryNews(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfCategoryWomen(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfCategoryMen(d));*/
        OpsNewsstand.clickOnCategoryNewsCover(d);
        Assert.assertEquals("News", OpsNewsstand.getCategoryIssueTitle(d));
        //To check the subcategories of news in fr store ,
        //todo : Check subcategory in women category to dev after creating the id
        //Assert.assertTrue(OpsNewsstand.checkVisibilityOfSubCategoriesMenuBar(d));
        //Roll back to the privious page
        OpsNewsstand.clickOnBackBarTitle(d);
        OpsNewsstand.clickOnBackfromCategories (d);

        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandCategoriesButton(d));

    }

    @Test(enabled = true)
    public void test_06_MenuItems() throws Exception {

        test = a.createTest("Newsstand: test_06_MenuItems", "");

        //blocs was modified to be Newsstand, Articles, My Library
        //TODO: add ids to these Newsstand Articles My Library
/*        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandMenuButton(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfArticlesMenuButton(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfLibraryMenuButton(d));*/

    }

    //switch store and check that elements are present
    @Test(enabled = false)
    public void test_08_SwitchStore() throws Exception {

        test = a.createTest("Newsstand: test_08_SwitchStore", "");
      //  OpsSignUp.clickOnUpButton(d);
        OpsNewsstand.clickOnMenuCountryButton(d);
        OpsNewsstand.clickOnFRFlagButton(d);
       // OpsNewsstand.clickOnBackButton(d);
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfCarrousel(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandHorizontalListView(d));
        //roll back from kiosque page

      //  OpsNewsstand.clickOnBackfromKiosque(d);
        OpsNewsstand.clickOnMenuCountryButton(d);
        OpsNewsstand.clickOnUKFlagButton(d);
      //  OpsNewsstand.clickOnBackButton (d);
    }

    //Turn off internet connection and check that the button bar is displayed

    @Test(enabled = false)
    public void test_09_OfflineMode() throws Exception {

        test = a.createTest("Newsstand: test_09_OfflineMode", "");
        d.getDriver().setConnection(Connection.AIRPLANE);
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandCategoriesButton(d));
        Assert.assertTrue(OpsNewsstand.checkVisibilityOfNewsstandConnectionBar(d));
        d.getDriver().setConnection(Connection.ALL);
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
