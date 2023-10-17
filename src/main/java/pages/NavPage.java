package pages;

//Nav Page
//        Home link
//        About link
//        My profile link
//        Admin dugme
//        Cities link iz padajuceg Admin menija
//        Users link iz padajuceg Admin menija
//        Sign up dugme
//        Login dugme
//        Logout dugme
//        Dugme za izbor jezika
//        EN dugme iz padajuceg menija za izbor jezika
//        ES dugme iz padajuceg menija za izbor jezika
//        FR dugme iz padajuceg menija za izbor jezika
//        CN dugme iz padajuceg menija za izbor jezika

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public  WebElement loginButton(){
        return driver.findElement(By.cssSelector("[href='/login'].btnLogin"));
    }
    public  WebElement getlanguageButton (){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getLanguageList () {
        return driver.findElement(By.cssSelector(".menuable__content__active > div"));
    }
    public void waitUntilLanguageListIsVisible () {
        wait
                .withMessage("Error! Language list should be visible.")
                .until(ExpectedConditions.visibilityOf(getLanguageList()));
    }
    public WebElement getLanguageEN() {
        return driver.findElement(By.cssSelector("span.f-gb"));
    }
    public void clickLanguageEN () {
        getLanguageEN().click();
    }
    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }
    public void waitUntilCurrentUrlContainsLogin () {
        wait
                .withMessage("Current url should contain '/login'.")
                .until(ExpectedConditions.urlContains("/login"));
    }
    public void waitUntilCurrentUrlContainsHome () {
        wait
                .withMessage("Current url should contain '/home'.")
                .until(ExpectedConditions.urlContains("/home"));
    }
    public  WebElement logoutButton(){
        return driver.findElement(By.cssSelector("button.hidden-sm-and-down btnLogout v-btn " +
                                                "v-btn--text theme--light v-size--default"));
    }
    public WebElement signupButton(){
        return driver.findElement(By.cssSelector("a[href='/signup']"));
    }
    public void waitUntilCurrentUrlContainsSignup (){
        wait
                .withMessage("Error! Current URL doesn't contain 'SignUp'")
                .until(ExpectedConditions.urlContains("/signup"));
    }
}
