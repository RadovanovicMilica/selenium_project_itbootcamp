package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.danielRetry;

public class AuthRoutesTests extends BasicTest{

    @Test (priority = 1, retryAnalyzer = danielRetry.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated (){
//        Ucitati /home stranu
//        Verifikovati da se u url-u stranice javlja ruta /login
        driver.navigate().to(baseUrl + "/home");
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl + "/login",
                "Error! Current URL isn't " + baseUrl+ "/login");
    }
    @Test (priority = 2, retryAnalyzer = danielRetry.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated (){
//        Koraci:
//        Ucitati /profile stranu
//        Verifikovati da se u url-u stranice javlja ruta /login
        driver.navigate().to(baseUrl + "/profile");
        Assert.assertEquals(navPage.getCurrentUrl(),
                baseUrl + "/login",
                "Error! Current URL isn't " + baseUrl+ "/login");
    }
}
