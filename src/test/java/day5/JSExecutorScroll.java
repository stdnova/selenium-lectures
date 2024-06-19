package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSExecutorScroll {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement


        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("hello", Keys.ENTER);
        Thread.sleep(1000);

        ( (JavascriptExecutor) driver).executeScript( "window.scrollBy(0, 500)" ); //500pax first X horiz > <, second Y vertical^

        for (int i = 0; i < 7; i++) {

            ( (JavascriptExecutor) driver).executeScript( "window.scrollBy(0, 500)" );
            Thread.sleep(1000);

        }


        Thread.sleep(10000);
        driver.quit();

    }

}

