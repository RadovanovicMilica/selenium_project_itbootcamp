package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Test #1: Visits the login page
//        Koraci:
//        Postaviti EN jezik stranice
//        Klik na login dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja ruta /login

public class LoginTest extends BasicTest{
    public LoginTest(WebDriver driver, WebDriverWait wait, String baseUrl) {
        super(driver, wait, baseUrl);
    }
}
