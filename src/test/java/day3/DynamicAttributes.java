package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class DynamicAttributes { // change with each load/refresh

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.rediff.com/");

        driver.findElement(By.linkText("Create Account")).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys("Allen Delon", Keys.TAB);


        Thread.sleep(5000);
        driver.quit();

    }


}
