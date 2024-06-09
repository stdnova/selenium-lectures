package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LocateElementByLinktext {
    @Test
    public void test01() throws InterruptedException {

        // 1. Get to the https://www.webstaurantstore.com/

        WebDriver driver = null;

        try {
            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get("https://www.webstaurantstore.com/");

            driver.findElement(By.linkText("Restaurant Equipment")).click();
        //    driver.findElement(By.partialLinkText("FREE Shipping")).click();

            Assert.assertTrue(driver.getTitle().contains("Commercial Restaurant Equipment"));



        } finally {
            Thread.sleep(1000);
            driver.quit();
        }
    }
}
