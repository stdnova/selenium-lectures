package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.StringReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class WarmUpTask {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // End-to-end test -> as a user how would you use this application is a type of integration test

            driver.get("https://www.hoteltonight.com/");

            driver.findElement(By.xpath("//div[.='Tonight'][not(@class)]")).click();

            driver.findElement(By.xpath("//span[@class='_vao1kgk']//span[.='10'][@class='_os6tbd']")).click();
            driver.findElement(By.xpath("//span[@class='_vao1kgk']//span[.='15'][@class='_os6tbd']")).click();
            driver.findElement(By.xpath("//button[.='Done']")).click();
            driver.findElement(By.xpath("//button[.='Go']")).click();

        List <WebElement> elements = driver.findElements(By.xpath("//div[@data-aid='inventory-item-rate']/span/span"));

       List <String> elementsText = SeleniumUtils.getElementsText(elements); //see day2 for method implementation

        System.out.println(elementsText);

        List<Integer> list = new ArrayList<>();

        elementsText.forEach( s -> list.add ( Integer.valueOf( s.replace("$","")) ) );

        list.sort(Comparator.reverseOrder());

        System.out.println("Sorted list: " + list);


        List<WebElement> links = driver.findElements(By.xpath("//h3[@data-aid='inventory-item-name']"));

        WebElement lastResult = links.get(links.size()-1);

        String expectedTitle = lastResult.getText();

        System.out.println("Expected Title: " + expectedTitle);

        new Actions(driver).keyDown(Keys.COMMAND).click(lastResult).perform();
        Thread.sleep(1000);

        String currentHandle = driver.getWindowHandle();

        Set <String> currentHandles = driver.getWindowHandles();

        for (String windowHandle : currentHandles) {
            if(!windowHandle.equals(currentHandle)){
                driver.switchTo().window(windowHandle);
            }
        }

        String actualTitle = driver.findElement(By.xpath("//h1[@data-aid='hotel-name']")).getText();

        System.out.println("Actual title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(5000);
            driver.quit();





    }
}
