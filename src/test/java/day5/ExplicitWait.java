package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[.='Remove']")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[.=\"It's gone!\"]")));

new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[.=\"It's gone!\"]")));

        System.out.println(driver.findElement(By.xpath("//p[.=\"It's gone!\"]")).getText());

// element is disabled but locatable but not interactable before clicking button
// driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");

        driver.findElement(By.xpath("//button[.='Enable']")).click();

WebElement webElement = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println(webElement.isDisplayed());
        System.out.println(webElement.isSelected());
        System.out.println(webElement.isEnabled());

        // enabled and visible is to clickable in this method
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.sendKeys("Hello");

        //TimeoutException: Expected condition failed: waiting for element to be clickable:









        Thread.sleep(5000);
        driver.quit();

    }

}

