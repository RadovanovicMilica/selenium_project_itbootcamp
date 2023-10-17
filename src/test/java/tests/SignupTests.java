package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import retry.danielRetry;

public class SignupTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = danielRetry.class)
    public void visitsTheSignupPage (){
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta

        navPage.signupButton().click();
        wait
                .withMessage("Error! Signup button doesn't exist on this url.")
                .until(ExpectedConditions.elementToBeClickable(navPage.signupButton()));
    }

}
