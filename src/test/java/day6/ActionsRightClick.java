package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsRightClick {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        // jquery tool used to build context menu in HTML

        Thread.sleep(2000);
        new Actions(driver).contextClick(driver.findElement(By.xpath("//span[.='right click me']")))
                .sendKeys((Keys.ARROW_DOWN))
                .sendKeys((Keys.ARROW_DOWN))
                .sendKeys((Keys.ARROW_DOWN))
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText(); // message displayed in an alert box
        alert.accept();

        System.out.println(textOnAlert);

        // Thread.sleep(4000);
     // driver.quit();


    }

}

