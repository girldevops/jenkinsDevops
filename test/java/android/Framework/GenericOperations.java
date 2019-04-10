package android.Framework;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by FatimaZahra on 11/07/2017.
 */
public class GenericOperations {

    //Generate random email addresses to be used to create new test accounts
    public static String emailAccount() {
        String email = "LK" + RandomStringUtils.randomAlphanumeric(6) + ".test@lekiosque.fr";
        return email;
    }
    /*
      //Scroll up/down into a list view and select an element
    public static void scroll(String elementClassName, String itemTitle) {
       // MobileElement listItem = (MobileElement) d.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().className(" + elementClassName + ")).scrollIntoView(new UiSelector().text(" + itemTitle + "));");
        //listItem.click();
    }
     */

}