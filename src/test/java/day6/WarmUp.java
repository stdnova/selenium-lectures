package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WarmUp {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.dice.com/");

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("IPGeoLocateButton")).click();
      //  driver.findElement(By.id("submitSearch-button")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='card-title-link normal']")));

SeleniumUtils.waitForPresenceOfAllElements(driver, Duration.ofSeconds(7), By.xpath("//a[@class='card-title-link normal']"));

// Visibility -> element is present on the page, in the HTML, but is not visible to end user, its status is not displayed, and you can locate that element
// Presence -> element is not even on the HTML yet, not even loaded, certain elements might load later, asynchronous on the page

        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='card-title-link normal']"));

        if (titles.isEmpty()){
            throw new RuntimeException("the list is empty");
        }

        for (WebElement title : titles) {
            System.out.println(title.getText());
        }


        WebElement firstResult = titles.get(0);
        firstResult.click();

        driver.navigate().back();
        driver.navigate().forward();




        //firstResult.click();
// StaleElementReferenceException: stale element reference: stale element not found
// When you store an element and then navigate away from the page or elements on the page are reloaded, the first result you stored is Stale, old
// the easiest fix is to relocate the element and then interact (do not use old reference),

SeleniumUtils.waitForPresenceOfAllElements(driver, Duration.ofSeconds(10), By.xpath("//a[@class='card-title-link normal']"));

titles = driver.findElements(By.xpath("//a[@class='card-title-link normal']"));
titles.get(0).click();

     driver.quit();

        //Another way of fixing the StaleElement Exception is to refresh the page and obtain the fresh reference

    }

}

