package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.instagram.com/");

        driver.findElement(By.name("username")).sendKeys("dfdfdfd");
        driver.findElement(By.name("password")).sendKeys("dfdfdsdsdsdssdfd", Keys.ENTER);

WebElement errorMessage = driver.findElement(By.xpath("//div[@class='_ab2z']"));

System.out.println(errorMessage.getText());

Assert.assertTrue(errorMessage.isDisplayed());




//        Sorry, your password was incorrect. Please double-check your password.


        //Thread.sleep(5000);
        //driver.quit();

    }

}

