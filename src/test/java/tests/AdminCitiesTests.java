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
                "Error! Current URL is not baseUrl + /admin/cities");
    }
    @Test(priority =2, retryAnalyzer = danielRetry.class)
    public void checksInputTypesForCreateEditNewCity (){
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        Kliknuti na New Item dugme
//        Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//        Verifikovati da polje za unos grada za atribut type ima tekst text
        navPage.adminButton().click();
        navPage.waitUntilAdminListIsVisible();
        navPage.citiesButtonFromDropdown().click();
        citiesPage.newItemButton().click();
        citiesPage.waitUntilCreateAndEditCityMessageIsVisible();
        Assert.assertEquals(citiesPage.nameInputFiledForAttributeType(),
                "text",
                "Error! Name input filed doesn't have 'text' value.");
    }
}
