package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        citiesPage.waitForCreateEditDialogVisibility();
        Assert.assertEquals(citiesPage.citiesNameInput().getAttribute("type"), "text",
                "The 'type' attribute for the cities name input field is not correct.");
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
        citiesPage.waitForCreateEditDialogVisibility();
        citiesPage.clearEndTypeCitiesNameField(city);
        citiesPage.dialogSaveButton().click();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditIsVisible();
        Assert.assertFalse(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEdit(),
                "Error! PopUp message doesn't contain text 'Saved successfully'.");
    }
    @Test(priority = 4, retryAnalyzer = danielRetry.class)
    public void  editCity(){
//     Podaci:
//old city name: [Ime i prezime polaznika]’s city
//new city name: [Ime i prezime polaznika]’s city Edited
//Koraci:
//Klik na admin dugme iz navigacije
//Klik na Cities dugme iz padajuceg Admin menija
//U polje za pretragu uneti staro ime grada
//Sacekati da broj redova u tabeli bude 1
//Kliknuti na dugme Edit iz prvog reda
//Uneti novo ime za grad
//Kliknuti na dugme Save
//Sacekati da popu za prikaz poruke bude vidljiv
//Verifikovati da poruka sadrzi tekst Saved successfully

        String oldCityName= "MilicaRadovanovic's city";
        String newCityName= "MilicaRadovanovic's city Edited";
        navPage.adminButton().click();
        navPage.citiesButtonFromDropdown().click();
        citiesPage.typeSearchCityInput(oldCityName);
        citiesPage.waitForNumberOfTableRows(1);
        citiesPage.clickOnEditButtonFromTableRow(1);
        citiesPage.typeEditCityInput(newCityName);
        citiesPage.clickOnDialogSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulAddOrEditIsVisible();
        Assert.assertFalse(messagePopUpPage.getTextFromPopUpMessageForSuccessfulAddOrEdit(),
                "Error! PopUp message with text 'Saved successfully' didn't visible.");
    }
    @Test (priority = 5, retryAnalyzer = danielRetry.class)
    public void searchCity () {
//    Podaci:
//    city name: [Ime i prezime polaznika]’s city Edited
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    U polje za pretragu uneti staro ime grada
//    Sacekati da broj redova u tabeli bude 1
//    Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage

        String cityName = "MilicaRadovanovic's city Edited";
        navPage.adminButton().click();
        navPage.citiesButtonFromDropdown().click();
//        citiesPage.waitForCreateEditDialogVisibility();
        citiesPage.typeSearchCityInput(cityName);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), cityName,
                " Error! City in the name field isn't " + cityName);
    }
    @Test (priority = 6, retryAnalyzer = danielRetry.class)
    public void deleteCity (){
//        Podaci:
//        city name: [Ime i prezime polaznika]’s city Edited
//        Koraci:
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        U polje za pretragu uneti staro ime grada
//        Sacekati da broj redova u tabeli bude 1
//        Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//        Kliknuti na dugme Delete iz prvog reda
//        Sacekati da se dijalog za brisanje pojavi
//        Kliknuti na dugme Delete iz dijaloga
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da poruka sadrzi tekst Deleted successfully
        String cityName = "MilicaRadovanovic's city Edited";
        navPage.adminButton().click();
        navPage.citiesButtonFromDropdown().click();
        citiesPage.typeSearchCityInput(cityName);
        citiesPage.waitForNumberOfTableRows(1);
        Assert.assertEquals(citiesPage.getTextFromField(1,2), cityName,
                "City in the name field should be " + cityName);
        citiesPage.clickOnDeleteButtonFromTable(1);
        citiesPage.deleteDialogVisible();
        citiesPage.clickOnDialogDeleteButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulDeleteIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulDelete(),
                "Error! Pop up message doesn't contain text 'Deleted successfully'.");


    }
}
