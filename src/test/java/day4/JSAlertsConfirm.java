package day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAlertsConfirm {

    @Test
    public void testCase() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Thread.sleep(2000);

// UnhandledAlertException: unexpected alert open: {Alert text : I am a JS Alert}

        // Switch the focus to alert and handle it
        driver.switchTo().alert().dismiss(); //Click cancel
       // driver.switchTo().alert().accept(); //Click OK //NoAlertPresentException: no such alert

        driver.findElement(By.linkText("Elemental Selenium")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
