package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsHoverOver {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.amazon.com/");

        WebElement link = driver.findElement(By.id("nav-link-accountList"));
Thread.sleep(2000);

        new Actions(driver).moveToElement(link).perform();


      //   Thread.sleep(1000);
     //driver.quit();


    }

}

