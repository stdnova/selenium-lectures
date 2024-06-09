package day2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.*;

public class GetAttributeMethod {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        WebElement searchBox =driver.findElement(By.id("searchval"));

        System.out.println(searchBox.getAttribute("aria-label"));

        String expected = "What are you looking for?";

       String actual = searchBox.getAttribute("placeholder");

        Assert.assertEquals(actual, expected);

        String term = "table";
        driver.findElement(By.id("searchval")).sendKeys(term, Keys.ENTER);

        String actualQuantity = driver.findElement(By.xpath("//input[@name='qty']")).getAttribute("value");

        Assert.assertEquals(actualQuantity, "1"); // you should compare the same types.

        //to get the text from any input box use getAttribute("value");

        System.out.println(driver.findElement(By.id("searchval")).getAttribute("value"));

        // find all links on the page and print their urls

       List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }



        Thread.sleep(5000);
        driver.close();

    }
}
