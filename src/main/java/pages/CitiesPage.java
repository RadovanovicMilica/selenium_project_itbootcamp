package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void fillInTheNameInputFiled (String cityName){
        nameInputFiled().clear();
        nameInputFiled().sendKeys(cityName);
    }
    public WebElement saveButtonForAddOrEdit (){
        return driver.findElement(By.className("btnSave"));
    }

//OVO IDE ZA TESTOVE KOJI SU U REZERVNOJ KLASI:
    public WebElement searchField (){
        return driver.findElement(By.cssSelector("div.flex xs12 sm6 md4 px-3"));
    }
    public void fillInSearch (String oldName){
        searchField().clear();
        searchField().sendKeys(oldName);
    }
    public void waitUntilNumberOfRowsInTheCityTableIsDefined (int numberOfRows ){
        wait
                .withMessage("Error! Number of rows in the table is not " + numberOfRows + "." )
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div.v-data-table__wrapper"),
                        numberOfRows));
    }
    public WebElement editCityButton (){
        return driver.findElement(By.id("edit"));
    }

}
