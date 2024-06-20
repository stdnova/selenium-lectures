package day3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Practice {

    @Test
    public void testCase() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.koonstoyotatysonscorner.com/");

        Select typeDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterType']")));
        Assert.assertEquals(typeDropdown.getFirstSelectedOption().getText(), "All");
        typeDropdown.selectByVisibleText("New");

        Select makeDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterMakes']")));
        Assert.assertEquals(makeDropdown.getFirstSelectedOption().getText(), "Toyota");
        makeDropdown.selectByVisibleText("Toyota");
        Thread.sleep(1000);

        Select modelDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterModels']")));
        Assert.assertEquals(modelDropdown.getFirstSelectedOption().getText(), "Any Model");
        modelDropdown.selectByVisibleText("RAV4");

        driver.findElement(By.cssSelector("button[class='search-by-filter__search-button desktop btn stat-button-link']")).click();
        Thread.sleep(5000);

     //   driver.findElement(By.id("ip-no")).click();
      //  Thread.sleep(1000);

        WebElement searchBox = driver.findElement(By.cssSelector("opensearch-P6NKLQ-input-desktop"));

        searchBox.click();
        searchBox.sendKeys("XLE Premium", Keys.ENTER);



// Thread.sleep(2000);
//driver.quit();




    }
}
