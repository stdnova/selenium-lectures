package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSExecutorClick {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.amazon.com/");
        Thread.sleep(10000);

        //driver.findElement(By.xpath("//span[.='Prime Membership']")).click();
//ElementNotInteractableException: element not interactable - element in fact exists on HTML but not visible
// clickintercepted

// One interface is castable to another interface in java. driver is an interface.

        //JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement link = driver.findElement(By.xpath("//span[.='Prime Membership']"));

        //js.executeScript("arguments[0].click();", link);

        // ( (JavascriptExecutor)driver ).executeScript("arguments[0].click();", link);

        SeleniumUtils.jsClick(driver, link); // method from day2




        Thread.sleep(5000);
        driver.quit();

    }

}

