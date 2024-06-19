package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FluentWaitDemo {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.dice.com/");

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("IPGeoLocateButton")).click();
      //  driver.findElement(By.id("submitSearch-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='card-title-link normal']")));

        // The default polling frequency for Implicit and Explicit wait id 1/2 second or 500ms

        // Fluent wait

        Wait fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("someElement")));

        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='card-title-link normal']"));

        if (titles.isEmpty()){
            throw new RuntimeException("the list is empty");
        }

        for (WebElement title : titles) {

            System.out.println(title.getText());

        }









        Thread.sleep(5000);
        driver.quit();

    }

}

