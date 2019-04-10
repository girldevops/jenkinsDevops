package android.Pages;

import android.Framework.AndroidConfigClass;
import android.Framework.ExtentReportManager;
import android.Operations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.BeforeClass;

public abstract  class AbstractTest {

    public static ExtentReports a;
    public static ExtentTest test;
    ExtentReportManager r= new ExtentReportManager ();

    protected static AndroidConfigClass d = new AndroidConfigClass();

    protected static OpsSignIn ops1 =new OpsSignIn (d.getDriver ());
    protected static OpsSignUp ops2=new OpsSignUp (d.getDriver ());
    protected static OpsForgottenPassword ops3=new OpsForgottenPassword (d.getDriver ());
    protected static OpsLogout ops4=new OpsLogout (d.getDriver ());
    protected static OpsMenu ops5=new OpsMenu (d.getDriver ());
    protected static OpsNewsstand ops6=new OpsNewsstand (d.getDriver ());
    protected static OpsOursOffers ops7=new OpsOursOffers (d.getDriver ());



}
