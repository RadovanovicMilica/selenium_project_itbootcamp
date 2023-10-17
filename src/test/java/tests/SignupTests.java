package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
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
    @Test (priority = 2, retryAnalyzer = danielRetry.class)
    public void checksInputTypes (){
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da polje za unos emaila za atribut type ima vrednost email
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//        Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password
        navPage.signupButton().click();
        navPage.waitUntilCurrentUrlContainsSignup();
        wait
                .withMessage("Error! Signup button doesn't exist on this url.")
                .until(ExpectedConditions.elementToBeClickable(navPage.signupButton()));
        String signupInputType= signupPage.addEmail().getAttribute("type");
        Assert.assertEquals(signupInputType,
                "email",
                "Error! The email input type is incorrect.");
        String passwordInputType= signupPage.addPassword().getAttribute("type");
        Assert.assertEquals(passwordInputType,
                "password",
                "Error! The password input type is incorrect.");
        String confirmPasswordType= signupPage.confirmPassword().getAttribute("type");
        Assert.assertEquals(confirmPasswordType,
                "password",
                "Error! The 'Confirm Password' input type is incorrect.");
    }

}
