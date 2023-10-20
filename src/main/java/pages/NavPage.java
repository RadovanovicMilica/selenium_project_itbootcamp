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
        return driver.findElement(By.cssSelector("header a[href='/login']"));
    }
    public  WebElement getlanguageButton (){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickLanguageButton (){
        getlanguageButton().click();
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

    public WebElement getLanguageES(){
        return driver.findElement(By.cssSelector(".btnES"));
    }
    public void clickLanguageES (){
        getLanguageES().click();
    }
    public WebElement getLanguageFR (){
        return driver.findElement(By.id("list-item-143"));
    }
    public void clickLanguageFR (){
        getLanguageFR().click();
    }
    public WebElement getLanguageCN (){
        return driver.findElement(By.id("list-item-145"));
    }
    public void clickLanguageCN (){
        getLanguageCN().click();
    }
    public WebElement getHeader (){
        return driver.findElement(By.cssSelector("h1.display-2"));
    }
    public String getHeaderText () {
       return getHeader().getText();
    }
    public String getCurrentUrl () {
        return driver.getCurrentUrl();
    }
    public void waitUntilCurrentUrlContainsLogin () {
        wait
                .withMessage("Error! Current URL doesn't contain '/login'.")
                .until(ExpectedConditions.urlContains("/login"));
    }
    public void waitUntilCurrentUrlContainsHome () {
        wait
                .withMessage("Error! Current URL doesn't contain '/home'.")
                .until(ExpectedConditions.urlContains("/home"));
    }
    public  WebElement logoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement signupButton(){
        return driver.findElement(By.cssSelector("header a[href='/signup']"));
    }
    public void clickOnSignupButton (){
        signupButton().click();
    }
    public void waitUntilCurrentUrlContainsSignup (){
        wait
                .withMessage("Error! Current URL doesn't contain 'SignUp'")
                .until(ExpectedConditions.urlContains("/signup"));
    }
    public WebElement adminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void waitUntilAdminListIsVisible(){
        wait
                .withMessage("Error! Admin list is not visible.")
                .until(ExpectedConditions.visibilityOf(adminButton()));
    }
    public WebElement citiesButtonFromDropdown (){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public void waitUntilCurrentUrlContainsAdminCities () {
        wait
                .withMessage("Error! Current URL doesn't contain '/admin/cities'.")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }
}
