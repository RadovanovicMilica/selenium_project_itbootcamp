package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
//Polje za unos imena
//        Polje za unos emaila
//        Polje za unos lozinke
//        Polje za potvrdi lozinku
//        Sign me up dugme

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement addName(){
        return driver.findElement(By.id("name"));
    }
    public WebElement addEmail(){
        return driver.findElement(By.id("email"));
    }
    public WebElement addPassword(){
        return driver.findElement(By.id("password"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement signupButton(){
        return driver.findElement(By.cssSelector( "button.secondary:contains('Sign me up')"));
    }

}
