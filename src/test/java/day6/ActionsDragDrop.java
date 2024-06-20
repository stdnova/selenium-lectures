package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDragDrop {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://javascript.info/mouse-drag-and-drop");

      SeleniumUtils.scrollBy(driver, 0, 7000);
      Thread.sleep(2000);

driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/article/mouse-drag-and-drop/ball4/']")));

        WebElement source = driver.findElement(By.id("ball"));
        WebElement target = driver.findElement(By.id("gate"));

        Thread.sleep(2000);
        new Actions(driver).dragAndDrop(source, target).perform();

        driver.switchTo().defaultContent();

        SeleniumUtils.scrollBy(driver, 0, -2900);
        Thread.sleep(2000);

driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://en.js.cx/article/mouse-drag-and-drop/ball3/']")));

        WebElement source1 = driver.findElement(By.id("ball"));

Thread.sleep(2000);
new Actions(driver).dragAndDropBy(source1, 500, 100).perform();

new Actions(driver).clickAndHold(source1).moveByOffset(500,100).release(source1).perform();





         Thread.sleep(1000);
     driver.quit();


    }

}

