package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
    public static void takeScreenshot(WebDriver driver, String downloadPath) throws IOException {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    }


    }

