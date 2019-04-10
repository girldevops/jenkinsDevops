package android.Pages;
import android.Framework.AndroidConfigClass;
import android.Operations.OpsMenu;
import android.Operations.OpsOursOffers;
import android.Operations.OpsSignIn;
import android.Operations.OpsSignUp;
import org.junit.*;

import org.openqa.selenium.interactions.touch.TouchActions;



public class OurOffersTest extends AbstractTest{



    @Test
    public void test_01_GraphicControll() throws Exception {

        OpsSignUp.clickOnUpButton(d);
        //TODO : Still we  can' t find Our offers id
        //OpsOursOffers.checkVisibilityOfOffersMenuButton(d);
        //OpsOursOffers.clickOnOurOffersOnMenu(d);
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfBloc1(d));
        // tow button to be checked
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfTryfButton(d));
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfBloc2(d));
        OpsOursOffers.scrollDownOurOffers (d);
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfBloc3(d));
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfBloc4(d));
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfTryfButton(d));
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfSecurePaymentBar (d));

    }

    @Test
    public void test_02_ButtonFreeTrial() throws Exception {

        //  Test click on try trial button
        OpsOursOffers.clickOnTryfButton(d);
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfPopupLeKioskAccount (d));


    }
    @Test
    public void test_03_ClickOutOfPopup() throws Exception {
        // click in our offers action bar to simulate click out of popup
        OpsOursOffers.clickOnbackBarAction (d);
        OpsOursOffers.checkVisibilityOfBloc1 (d);
    }
    @Test
    public void test_04_LoginFromPopup() throws Exception {

        OpsOursOffers.clickOnTryfButton(d);
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfPopupLeKioskAccount (d));
        OpsOursOffers.clickOnLogin (d);
        OpsSignIn.checkVisibilityOfSignInFormButton (d);
        OpsOursOffers.clickOnbackBarAction (d);

    }
    @Test
    public void test_05_RegisterFromPopup() throws Exception {

        OpsOursOffers.clickOnTryfButton(d);
        Assert.assertTrue(OpsOursOffers.checkVisibilityOfPopupLeKioskAccount (d));
        OpsOursOffers.clickOnRegister (d);
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfFacebookSignUpButton(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpSubTitleLabel(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpEmailField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpPasswordConfirmationField(d));
        Assert.assertTrue(OpsSignUp.checkVisibilityOfSignUpByEmailButton(d));
        //roll back  to the privious page
        OpsOursOffers.clickOnbackBarAction (d);


    }

    @Test
    public void test_06_ViewMagazines() throws Exception {

        OpsOursOffers.scrollDownOurOffers (d);
        OpsOursOffers.clickOnViewMagazines(d);
        OpsOursOffers.checkVisibilityOfEligiblemagsList(d);
    }

    @AfterClass
    public static void tearDown(){

        d.getDriver().resetApp ();
    }

}
