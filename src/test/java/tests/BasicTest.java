package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.*;

import java.time.Duration;

public class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl= "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected MessagePopUpPage messagePopUpPage;
    protected SignupPage signupPage;
protected CitiesPage citiesPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navPage = new NavPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        messagePopUpPage= new MessagePopUpPage(driver, wait);
        signupPage= new SignupPage(driver, wait);
        citiesPage= new CitiesPage(driver, wait);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(baseUrl);
    }
    @AfterMethod
    public void afterMethod() {


        }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
