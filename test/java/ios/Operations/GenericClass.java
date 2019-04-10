package ios.Operations;

import io.appium.java_client.MobileElement;
import ios.iOSConfigClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by m.doudouch on 12/09/2017.
 */
public class GenericClass {

    static iOSConfigClass d = new iOSConfigClass();
    public static final String lkMail = ".test@lekiosque.fr";
    public static final String lk = "LK";

    /*-------------------------EMail Account Generator-------------------------*/
    public static String emailAccountGenerator(){
        String email = lk + RandomStringUtils.random(6,true,true) + lkMail;
        return email;
    }

    /*-------------------------Swipe Down Function-------------------------*/
    public static void swipeDown(iOSConfigClass d, String elementName){
        Dimension dimension = d.getDriver().manage().window().getSize();

        Double  screenHeightStart = dimension.getHeight()*0.5;
        int scrollStart = screenHeightStart.intValue();

        Double screenHeightEnd = dimension.getHeight()*0.2;
        int scrollEnd = screenHeightEnd.intValue();

        for(int i=0; i<dimension.getHeight(); i++){
            d.getDriver().swipe(0,scrollStart,0,scrollEnd,2000);
            if(d.getDriver().findElement(By.name(elementName)).isDisplayed())
                break;
        }
    }

    /*-------------------------FindWhichView-------------------------*/
    public static String findView(iOSConfigClass d){
        String viewName="";

        for(int i=0; i<=4; i++){
            if (d.getDriver().findElement(By.name("ALNewsstandUIButtonMenu")).isDisplayed())
            {
                viewName = "NEWSSTAND";
                break;
            }

            else if (d.getDriver().findElement(By.name("ALSearchBar")).isDisplayed())
            {
                viewName = "SEARCH";
                break;
            }
            else if (d.getDriver().findElement(By.name("ALMySpaceButtonMenu")).isDisplayed())
            {
                viewName = "READER";
                break;
            }
        }

        return viewName;
    }

    /*-------------------------Open News Stand Menu-------------------------*/
    public static void openNewsStandMenu (iOSConfigClass d) {
        WebDriverWait wait = new WebDriverWait(d.getDriver(), 10);
        wait.until(presenceOfElementLocated(By.name("ALNewsstandUIButtonMenu")));
        d.getDriver().findElement(By.name("ALNewsstandUIButtonMenu")).click();

    }

}
