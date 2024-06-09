package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetTextMethod {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        System.out.println(driver.findElement(By.xpath("//span[@class='leading-none']")).getText());

    }

    }
