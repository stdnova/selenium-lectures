package day4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Iframes2_JSexecutor {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.duotech.io/enroll-sqae2");

        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, '1718')]")));

        driver.findElement(By.xpath("//input[@placeholder='First']")).sendKeys("Hello", Keys.TAB);

// Interact again with the main window
// Switch the context/focus to the main window
        driver.switchTo().defaultContent(); // gets to the main window

//        driver.switchTo().parentFrame(); // used with nested iframes to switch to from inner back up one not the main default window

//        driver.findElement(By.linkText("Contacts")).click();

        WebElement contactsLInk = driver.findElement(By.linkText("Contacts"));

// Using JS you can click on anything that throws ELementClickInterceptedException or ELementNotInteractable

        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", contactsLInk);

        Thread.sleep(3000);
        driver.quit();



    }

    }
