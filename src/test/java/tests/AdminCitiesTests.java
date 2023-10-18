package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.danielRetry;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1, retryAnalyzer = danielRetry.class)
    public void visitsTheAdminCitiesPageAndListCities (){
//        Podaci:
//        admin email: admin@admin.com
//        admin password: 12345
//        Koraci:
//        Klik na login dugme iz navigacije
//        Prijaviti se na sistem admin kredencijalima
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        Verifikovati da se u url-u stranice javlja /admin/cities ruta
    String adminMail= "admin@admin.com";
    String adminPassword= "12345";
    navPage.loginButton().click();
    loginPage.clearAndTypeEmailInput(adminMail);
    loginPage.clearAndTypePassword(adminPassword);
    loginPage.clickOnLoginButton();
    navPage.adminButton().click();
    navPage.waitUntilAdminListIsVisible();
    navPage.citiesButtonFromDropdown().click();
        Assert.assertEquals(navPage.getCurrentUrl(),baseUrl + "/admin/cities",
                "Error! Curent URL is not baseUrl + /admin/cities");
    }
}
