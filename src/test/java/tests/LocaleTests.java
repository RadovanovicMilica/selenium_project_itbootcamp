package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.danielRetry;

public class LocaleTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = danielRetry.class)
    public void setLocaleToES (){
//        Postaviti jezik na ES
//        Verifikovati da se na stranici u hederu javlja tekst Página de aterrizaje

        navPage.clickLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickLanguageES();
        Assert.assertEquals(navPage.getHeaderText(),
                "Página de aterrizaje",
                "Error! Text in Header is not 'Página de aterrizaje'.");
    }
    @Test (priority = 2, retryAnalyzer = danielRetry.class)
    public void setLocaleToEN (){
//        Postaviti jezik na EN
//        Verifikovati da se na stranici u hederu javlja tekst Landing
        navPage.clickLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickLanguageEN();
        Assert.assertEquals(navPage.getHeaderText(),
                "Landing",
                "Error! Text in Header is not 'Landing'.");
    }
    @Test (priority = 3, retryAnalyzer = danielRetry.class)
    public void setLocaleToCN (){
//        Koraci:
//        Postaviti jezik na CN
//        Verifikovati da se na stranici u hederu javlja tekst 首页
        navPage.clickLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickLanguageEN();
        Assert.assertEquals(navPage.getHeaderText(),
                "首页",
                "Error! Text in Header is not '首页'.");
    }
    @Test(priority = 4, retryAnalyzer = danielRetry.class)
    public void setLocaleToFR (){
//        Koraci:
//        Postaviti jezik na FR
//        Verifikovati da se na stranici u hederu javlja tekst Page d'atterrissage
        navPage.clickLanguageButton();
        navPage.waitUntilLanguageListIsVisible();
        navPage.clickLanguageEN();
        Assert.assertEquals(navPage.getHeaderText(),
                "d'atterrissage",
                "Error! Text in Header is not 'd'atterrissage'.");
    }


}
