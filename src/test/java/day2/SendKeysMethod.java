package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendKeysMethod {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        driver.findElement(By.id("searchval")).sendKeys(Keys.chord(Keys.SHIFT, "table"));
        driver.findElement(By.id("searchval")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);

    }


    }
