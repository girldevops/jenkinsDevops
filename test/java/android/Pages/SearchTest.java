package android.Pages;

import android.Framework.AndroidConfigClass;
import android.Operations.OpsSearch;
import android.Operations.OpsSignUp;
import io.appium.java_client.android.Connection;
import org.junit.*;


/**
 * Created by FatimaZahra on 27/01/2017.
 */



public class SearchTest extends AbstractTest{

    static AndroidConfigClass d = new AndroidConfigClass();

    @BeforeClass
    public static void beforeClass() {
        OpsSignUp.skipAppUpdateAlert(d); //In case update popup apprears close it before proceeding to test
    }

    //Online mode
    @Test
    //Should not show results for an unexisting keyword
    public void testASearchWithUnexistingKeyword() throws Exception {
        OpsSearch.clickOnSearchButton(d);
        OpsSearch.clearSearchField(d);
        OpsSearch.typeSearchKeyWord(d, "XXXX" + "\n");
        Assert.assertEquals("Aucun résultat", OpsSearch.getNoResultText(d));
    }

    @Test
    //Should show result for titles close to the given keyword
    public void testBSearchWithCloseKeyWord() throws Exception {
        OpsSearch.clickOnClearSearchCross(d);
        OpsSearch.typeSearchKeyWord(d, "poin" + "\n");
        OpsSearch.clickOnSearchResultCover(d);
        Assert.assertEquals("Le Point", OpsSearch.getIssueTitle(d));
    }

    @Test
    //Should show results for an existing title
    public void testCSearchForExistingTitle() throws Exception {
        OpsSearch.clickOnMenuBackButton(d);
        OpsSearch.clickOnClearSearchCross(d);
        OpsSearch.typeSearchKeyWord(d, "Le Point" + "\n");
        OpsSearch.clickOnSearchResultCover(d);
        Assert.assertEquals("Le Point", OpsSearch.getIssueTitle(d));
    }

    //OffLine mode
    @Test
    //No results found in offLine mode.
    public void testDSearchInOffLineMode() throws Exception {
        //set connection to OFF
        d.getDriver().setConnection(Connection.AIRPLANE);
        //test Start
        OpsSearch.clickOnMenuBackButton(d);
        OpsSearch.clickOnClearSearchCross(d);
        OpsSearch.typeSearchKeyWord(d, "OffLineText" + "\n" + "\n");
        Assert.assertEquals("Problème de connexion", OpsSearch.getOfflineText(d));
        d.getDriver().setConnection(Connection.ALL); //Set conection to ON
    }

    //TODO search in cache
    //Search in cache test case could not be tested because the functionality is not implemented, the search result is
    // not shown after internet goes off


    @AfterClass
    public static void tearDown(){
        d.getDriver().resetApp ();
    }


}
