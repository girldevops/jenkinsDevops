package android.Operations;

import android.Pages.AbstractTest;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will contain all the methods that are shared between all concretes
 * Screen objects. for example: dynamic waits, screenshots performing...
 */

class AbstractOperation extends AbstractTest {
    // this wait  is an explicit waits to use just for some elements if needed
    static WebDriverWait wait = new WebDriverWait(d.getDriver(), 60);
}
