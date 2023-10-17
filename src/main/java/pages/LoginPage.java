package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Login Page
//        Polje za unos email-a
//        Polje za unos lozinke
//        Dugme za login.

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmailInput(String email) {
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }
    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePassword(String password) {
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.className("v-btn--is-elevated"));
    }
    public void clickOnLoginButton() {
        getLoginButton().click();
    }

}
