package android.Operations;

import android.Framework.AndroidConfigClass;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by FatimaZahra on 16/06/2017.
 */
public class OpsNewsstand extends AbstractOperation{
    public OpsNewsstand(AppiumDriver<MobileElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator (driver, 240, TimeUnit.SECONDS), this);
    }

    //------------------- Define elements ------------

    @AndroidFindBy(id = "menu_newsstand_action_categories")
    private static MobileElement MenuNewsstandCategories;
    @AndroidFindBy (id = "fr.lekiosque:id/imageView_library_issue_cover")
    private static MobileElement CategoryNewsCover ;
    @AndroidFindBy (id = "MenuCountryButton")
    private static MobileElement MenuCountryButton;
    // to be modified
    @AndroidFindBy (xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.CheckedTextView[2]")
    private static MobileElement UKFlagButton;
    @AndroidFindBy (xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.CheckedTextView[1]")
    private static MobileElement FRFlagButton;
    @AndroidFindBy (id = "fr.lekiosque:id/back_button")
    private static MobileElement BackBarTitle;
    @AndroidFindBy (id = "NewsstandCarouselImageView")
    private static MobileElement CarouselImageView;
    @AndroidFindBy (id = "fr.lekiosque:id/newsStandHorizontalListView")
    private static MobileElement NewsStandHorizontalListView;
    @AndroidFindBy (id = "menu_newsstand_action_categories")
    private static MobileElement NewsstandCategoriesButton ;
    @AndroidFindBy (id = "NewsstandNoConectionTextView")
    private static MobileElement NewsstandNoConectionTextView;
    @AndroidFindBy (id = "Newsstand")
    private static MobileElement Newsstand;
    @AndroidFindBy (id = "MyLibrary")
    private static MobileElement MyLibrary;
    @AndroidFindBy (id = "Articles")
    private static MobileElement Articles ;
    @AndroidFindBy (id = "CDCategorySubCategoryUIMenuBar")
    private static MobileElement CDCategorySubCategoryMenuBar ;
    @AndroidFindBy (id = "fr.lekiosque:id/title_textview")
    private static MobileElement CategoryIssueTitle ;
    @AndroidFindBy (id = "fr.lekiosque:id/imageView_cover")
    private static MobileElement CategoryIssueImage ;
    @AndroidFindBy (xpath = "//android.widget.LinearLayout[@content-desc=\"Categories, Navigate up\"]")
    private static MobileElement BackCategories;
    @AndroidFindBy (id = "android:id/up")
    private static MobileElement backButton ;
    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc=\"Open on phone\"]")
    private static MobileElement UpButton;
    @AndroidFindBy (xpath = "//android.widget.LinearLayout[@content-desc=\"Kiosque, Parcourir vers le haut\"]")
    private static MobileElement BackfromKiosque;





    //------------------------click-------------------------
    public static void clickOnNewsstandMenuCategoriesButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Newsstand Menu Categories Button");
        MenuNewsstandCategories.click();
    }

    public static void clickOnCategoryNewsCover(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Category News Cover");
        CategoryNewsCover.click(); //id to be added temp id
    }

    public static void clickOnMenuCountryButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Menu Country Button");
        MenuCountryButton.click();
    }

    public static void clickOnUKFlagButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On UK Flag Button");
        UKFlagButton.click();
    }

    public static void clickOnFRFlagButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On FR Flag Button");
        FRFlagButton.click();
    }
    public static void clickOnBackBarTitle(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Back Bar Title");
        BackBarTitle.click();
    }
    public static void clickOnBackfromCategories(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Back from Categories");
        BackCategories.click();
    }
    public static void clickOnBackButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Back Button");
        backButton.click();
    }
    public static void clickOnUpButton(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Up Button");
        UpButton.click();
    }
    public static void clickOnBackfromKiosque(AndroidConfigClass d) {

        test.log (Status.INFO,"click On Back from Kiosque");
        BackfromKiosque.click();
    }


    //--------------------check visibility of element---------------
    public static boolean checkVisibilityOfCarrousel(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Carrousel");
        return CarouselImageView.isDisplayed();
    }

    public static boolean checkVisibilityOfNewsstandHorizontalListView(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Newsstand Horizontal List View");
        return NewsStandHorizontalListView.isDisplayed();
    }

    public static boolean checkVisibilityOfNewsstandCategoriesButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Newsstand Categories Button");
        return NewsstandCategoriesButton.isDisplayed();
    }

    public static boolean checkVisibilityOfCategoryNews(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Category News");
        return d.getDriver().findElement(By.id("")).isDisplayed();
    }

    public static boolean checkVisibilityOfCategoryWomen(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Category Women");
        return d.getDriver().findElement(By.id("")).isDisplayed();
    }

    public static boolean checkVisibilityOfCategoryMen(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Category Men");
        return d.getDriver().findElement(By.id("")).isDisplayed();
    }

    public static boolean checkVisibilityOfNewsstandConnectionBar(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Newsstand Connection Bar");
        // id was modified
        return NewsstandNoConectionTextView.isDisplayed();
    }
    // Down menu Newsstand , Articles & Library

    public static boolean checkVisibilityOfNewsstandMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Newsstand Menu Button");
        //Newsstand Button modified to be injected in the code as Newsstand
        return Newsstand.isDisplayed();
    }

    public static boolean checkVisibilityOfLibraryMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Library Menu Button");
        return MyLibrary.isDisplayed();
    }

    public static boolean checkVisibilityOfArticlesMenuButton(AndroidConfigClass d) {

        test.log (Status.INFO,"check Visibility Of Articles Menu Button");
        return Articles.isDisplayed();
    }
    public static boolean checkVisibilityOfSubCategoriesMenuBar(AndroidConfigClass d) {

        test.log (Status.INFO,"checkVisibilityOfSubCategoriesMenuBar");
        return CDCategorySubCategoryMenuBar.isDisplayed();

    }

    //-----------------------get text-------------------------------
    public static String getCategoryIssueTitle(AndroidConfigClass d) {

        wait.until(visibilityOf(CategoryIssueImage));
        return CategoryIssueTitle.getText();
    }


}
