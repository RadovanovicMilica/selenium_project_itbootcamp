package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getErrorPopup() {
        By errorPopupLocator = By.cssSelector(".v-snack__content ul li");
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(errorPopupLocator));
    }
    public String getErrorText() {
        return getErrorPopup().getText();
    }
    public void waitUntilErrorPopupIsVisible () {
        wait
                .withMessage("Pop-up message for invalid login should be visible.")
                .until(ExpectedConditions.visibilityOf(getErrorPopup()));
    }
    public WebElement errorPupUp(){
        return driver.findElement(By.cssSelector("div.v-snack__content"));
    }
    public String getTextError(){
        return errorPupUp().getText();
    }
    public void waitUntilErrorPopUpIsVisible () {
        wait
                .withMessage("Error! Pop-up message for invalid login isn't visible.")
                .until(ExpectedConditions.visibilityOf(errorPupUp()));
    }
    public WebElement verifyAccountPopUpMessage(){
        return driver.findElement(By.className("v-card__title"));
    }
    public void waitUntilVerifyYourAccountIsVisible () {
        wait
                .withMessage("Error! Message 'Verify your account' isn't visible.")
                .until(ExpectedConditions.visibilityOf(verifyAccountPopUpMessage()));
    }
    public String getTextFromVerifyAccountPopUpMessage (){
        return verifyAccountPopUpMessage().getText();
    }
    public WebElement closeButton(){
        return driver.findElement(By.className("btnClose"));
    }

    public WebElement popUpMessageForSuccessfulAddOrEdit (){
        return driver.findElement(By.className("v-snack__content"));
    }
    public void waitUntilPopUpMessageForSuccessfulAddOrEditIsVisible(){
        wait
                .withMessage("Error! PopUp message for successful add or edit is not visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }
    public boolean getTextFromPopUpMessageForSuccessfulAddOrEdit (){
        return popUpMessageForSuccessfulAddOrEdit().getText().contains("saved successfully");
    }
    public void waitUntilPopUpMessageForSuccessfulDeleteIsVisible() {
        wait
                .withMessage("Error! PopUp message for successful delete is not visible.")
                .until(ExpectedConditions.visibilityOf(popUpMessageForSuccessfulAddOrEdit()));
    }
    public boolean getTextFromPopUpMessageForSuccessfulDelete () {
            return popUpMessageForSuccessfulAddOrEdit().getText().contains("Deleted successfully");
        }
}
