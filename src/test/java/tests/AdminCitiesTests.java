package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
    @Test (priority = 3, retryAnalyzer = danielRetry.class)
    public void  createNewCity (){
//        Podaci:
//        city: [Ime i prezime polaznika]’s city
//        Koraci:
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        Kliknuti na New Item dugme
//        Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//        Uneti ime grada u polje
//        Kliknuti na Save dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da poruka sadrzi tekst Saved successfully
        String city= "MilicaRadovanovic's city";
        navPage.adminButton().click();
        navPage.citiesButtonFromDropdown().click();
        citiesPage.newItemButton().click();
        citiesPage.waitUntilCreateAndEditCityMessageIsVisible();
        citiesPage.fillInTheNameInputFiled(city);
        citiesPage.saveButtonForAddOrEdit().click();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditIsVisible();
        Assert.assertFalse(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEdit(),
                "Error! PopUp message doesn't contain text 'Saved successfully'.");

    }
}
