package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class CSSSelectorLocator {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.carfax.com/");

        driver.findElement(By.linkText("Used Car Values")).click();

        // Using class
        // div.text-input -> div with a class text input
        // .text-input -> any element with this class
        // .text-input.another-class -> elements with multiple classes

        List<WebElement> elements = driver.findElements(By.cssSelector("a.cgh__drop-menu-item"));

        for (WebElement element : elements) {
            System.out.println(element.getAttribute(("href")));
        }

        //Using id ->#someId

        driver.findElement(By.cssSelector("#plate")).sendKeys("UFO3456");

        Thread.sleep (3000);

//Using attribute
// input[aria-label='License Plate Number']

        driver.findElement(By.cssSelector("input[aria-label='License Plate Number']")).clear();
        driver.findElement(By.cssSelector("input[aria-label='License Plate Number']")).sendKeys("HELLO");

        Thread.sleep (3000);
        driver.quit();
    }


}
