package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingCheckboxes {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.carfax.com/");

        driver.findElement(By.linkText("Used Car Values")).click();

        //ElementClickInterceptedException - happens when an element is covered by another element
        // One way to fix it is to click on the other element that is covering it
        // Another way is to use Javascript click

        //driver.findElement(By.cssSelector("input[type='checkbox']")).click(); // input is covered by div

        WebElement checkbox = driver.findElement(By.cssSelector(".checkbox-input_box")); //clicked on the other element that covered input

        if (!checkbox.isSelected()){
            checkbox.click();
        }

          driver.quit();
    }

    }
