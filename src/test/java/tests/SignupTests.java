package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;
import retry.danielRetry;

import static org.testng.Assert.assertTrue;

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
    @Test (priority = 3, retryAnalyzer = danielRetry.class)
    public void  displaysErrorsWhenUserAlreadyExists (){
//        Podaci:
//        name: Another User
//        email: admin@admin.com
//        password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta
//        Popuniti formu za registraciju podacima
//        Klik na sign up dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku E-mail already exists
//        Verifikovati da se u url-u stranice javlja /signup ruta
        String name= "Another User";
        String mail= "admin@admin.com";
        String password= "12345";
        String confirmPassword= "12345";
        navPage.signupButton().click();
        navPage.waitUntilCurrentUrlContainsSignup();
        wait
                .withMessage("Error! Signup button doesn't exist on this url.")
                .until(ExpectedConditions.elementToBeClickable(navPage.signupButton()));
        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(mail);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.signupMeButton().click();

        messagePopUpPage.waitUntilErrorPopUpIsVisible();
        String errorText = messagePopUpPage.getTextError();
       Assert.assertFalse (errorText.contains("Email already exists."),
                "Error! Expected error message not found.");
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl+("/signup"),
                "Error! URL is not valid.");
    }
    @Test (priority = 4, retryAnalyzer = danielRetry.class)
    public void signup (){
//        Podaci:
//        name: Ime i prezime polaznika
//        email template: ime.prezime@itbootcamp.rs
//        password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Popuniti formu podacima za registraciju
//        Klik na sign up dugme
//        Ucitati stranicu /home
//        Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//        Kliknuti na Close dugme iz dijaloga
//        Kliknuti na logout
        String name= "Milica Radovanovic";
        String mail= "milica.radovanovic@itbootcamp.rs";
        String password= "12345";
        String confirmPassword= "12345";
        navPage.clickOnSignupButton();
        navPage.waitUntilCurrentUrlContainsSignup();
        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(mail);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(confirmPassword);
        signupPage.signupMeButton().click();
//        navPage.waitUntilCurrentUrlContainsHome();
        messagePopUpPage.waitUntilVerifyYourAccountIsVisible();
        String errorText = messagePopUpPage.getTextFromVerifyAccountPopUpMessage();
        Assert.assertEquals (errorText,
                "IMPORTANT: Verify your account.",
                "Error! There is no notification 'IMPORTANT: Verify your account'");
        messagePopUpPage.closeButton().click();
        navPage.logoutButton().click();
    }

}
