package android.Operations;

import android.Framework.AndroidConfigClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by FatimaZahra on 16/06/2017.
 */
public class OpsSearch extends AbstractOperation{
    //---------------------click------------------------------
    public static void clickOnSearchButton(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("Recherche")));
        d.getDriver().findElement(By.id("Recherche")).click();
    }

    public static void clickOnClearSearchCross(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("Effacer la requête")));
        d.getDriver().findElement(By.id("Effacer la requête")).click();
    }

    public static void clickOnSearchResultCover(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDSearchItemUICover")));
        d.getDriver().findElement(By.id("CDSearchItemUICover")).click();
    }

    public static void clickOnMenuBackButton (AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDMenuBackUIButtun")));
        d.getDriver().findElement(By.id("CDMenuBackUIButtun")).click();
    }

    //---------------------clear----------------------------
    public static void clearSearchField(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDSearchUIText")));
        d.getDriver().findElement(By.id("CDSearchUIText")).clear();
    }

    //-------------------send keys---------------------------
    public static void typeSearchKeyWord(AndroidConfigClass d, String value) {

        wait.until(visibilityOfElementLocated(By.id("CDSearchUIText")));
        d.getDriver().findElement(By.id("CDSearchUIText")).sendKeys(value);
    }

    //------------------get text-------------------
    public static String getNoResultText(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDSearchNoResultUIText")));
        return d.getDriver().findElement(By.id("CDSearchNoResultUIText")).getText();
    }

    public static String getIssueTitle(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDIssueTitleUILabel")));
        return d.getDriver().findElement(By.id("CDIssueTitleUILabel")).getText();
    }

    public static String getOfflineText(AndroidConfigClass d) {

        wait.until(visibilityOfElementLocated(By.id("CDSearchTextInternetProblem")));
        return d.getDriver().findElement(By.id("CDSearchTextInternetProblem")).getText();
    }
}
