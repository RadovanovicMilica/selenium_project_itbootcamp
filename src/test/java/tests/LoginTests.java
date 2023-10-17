package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;
import pages.LoginPage;
import pages.NavPage;
import retry.danielRetry;

import java.util.NavigableMap;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = danielRetry.class)
    public void visitTheLoginPage() {
//        Postaviti EN jezik stranice
//        Klik na login dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja ruta /login

        navPage.getlanguageButton().click();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickLanguageEN();
        navPage.loginButton().click();
        wait
                .withMessage("Error! Login button doesn't exist on this url.")
                .until(ExpectedConditions.elementToBeClickable(navPage.loginButton()));

    }
    @Test(priority = 2, retryAnalyzer = danielRetry.class)
    public void checksInputTypes (){
//        Klik na login dugme iz navigacije
//        Verifikovati da polje za unos emaila za atribut type ima vrednost email
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
        navPage.loginButton().click();
        navPage.waitUntilCurrentUrlContainsLogin();
        wait
                .withMessage("Error! Login button doesn't exist on this url.")
                .until(ExpectedConditions.elementToBeClickable(navPage.loginButton()));
                String emailInputType=loginPage.getEmailInput().getAttribute("type");
        Assert.assertEquals(emailInputType,
                "email",
                "Error! The email input field type is incorrect.");
                String passwordInputType= loginPage.getPasswordInput().getAttribute("type");
                Assert.assertEquals(passwordInputType,
                        "password",
                        "Error! The password input field type is incorrect.");
    }
    @Test(priority = 3, retryAnalyzer = danielRetry.class)
    public void displaysErrorsWhenUserDoesNotExist (){
//    email: non-existing-user@gmal.com
//    password: password123
//    Koraci:
//    Klik na login dugme iz navigacije
//    Popuniti login formu podacima za logovanje
//    Klik na login dugme
//    Sacekati da popu za prikaz greske bude vidljiv
//    Verifikovati da greska sadrzi poruku User does not exists
//    Verifikovati da se u url-u stranice javlja /login ruta

    String email= "non-existing-user@gmal.com";
    String password= "password123";
    navPage.loginButton().click();
    loginPage.clearAndTypeEmailInput(email);
    loginPage.clearAndTypePassword(password);
    loginPage.clickOnLoginButton();
    messagePopUpPage.waitUntilErrorPopupIsVisible();
    String errorText = messagePopUpPage.getErrorText();
    Assert.assertTrue(errorText.contains("User does not exist"),
            "Error! The error text is not valid.");
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl+("/login"),
            "Error! URL is not valid.");
}
    @Test (priority = 4, retryAnalyzer = danielRetry.class)
    public void displaysErrorWhenPasswordIsWrong (){
//        Podaci:
//        email: admin@admin.com
//        password: password123
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Klik na login dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku Wrong password
//        Verifikovati da se u url-u stranice javlja /login ruta
        String email= "admin@admin.com";
        String password= "password123";
        navPage.loginButton().click();
        loginPage.clearAndTypeEmailInput(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        messagePopUpPage.waitUntilErrorPopupIsVisible();
        Assert.assertEquals(messagePopUpPage.getErrorText(),
                "Wrong password",
                "Error! The error text is not valid.");
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl+("/login"),
                "Error! URL is not valid.");
    }
    @Test (priority = 5,retryAnalyzer = danielRetry.class)
    public void login (){
//        Podaci:
//        email: admin@admin.com
//        password: 12345
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Verifikovati da se u url-u stranice javlja /home ruta
        String email= "admin@admin.com";
        String password= "12345";
        navPage.loginButton().click();
        loginPage.clearAndTypeEmailInput(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        navPage.waitUntilCurrentUrlContainsHome();
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl+("/home"),
                "Error! URL is not valid.");
    }
    @Test (priority = 6, retryAnalyzer = danielRetry.class)
    public void logout (){
//    Verifikovati da je dugme logout vidljivo na stranici
//    Kliknuti na logout dugme
    navPage.logoutButton().click();

        wait
               .withMessage("Error! Logout button doesn't exist on this url.")
               .until(ExpectedConditions.elementToBeClickable(navPage.logoutButton()));
        navPage.logoutButton().click();
    }



}
