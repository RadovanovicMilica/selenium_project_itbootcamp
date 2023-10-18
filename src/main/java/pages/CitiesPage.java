package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement newItemButton (){
        return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement popUpForAddOrEditCities(){
        return driver.findElement(By.className("dlgNewEditItem"));
    }
    public void waitUntilCreateAndEditCityMessageIsVisible(){
        wait
                .withMessage("Error! PopUp message for create or edit City is not visible.")
                .until(ExpectedConditions.visibilityOf(popUpForAddOrEditCities()));
    }
    public WebElement nameInputFiled (){
        return driver.findElement(By.id("name"));
    }
    public String nameInputFiledForAttributeType (){
        return nameInputFiled().getAttribute("type");

    }
}
