package day6;

import day2.SeleniumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TakingScreenshots {

    @Test
    public void testCase() throws InterruptedException, IOException {

        WebDriver driver = null;

        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
            driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester", Keys.TAB,
                    "test123", Keys.ENTER);
            driver.findElement(By.linkText("Order"));
        } catch (Exception e) {

          File screenshotFile =  ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

       //   FileUtils.copyFile(screenshotFile, new File("screenshot.png")); saves to the main project folder
       FileUtils.copyFile(screenshotFile, new File("src/test/java/day6/screenshot"+ System.currentTimeMillis()+".png")); //saves to the days6 folder

    } finally {
            driver.quit();
        }


    }

}

