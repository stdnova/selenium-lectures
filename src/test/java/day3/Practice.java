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
        Thread.sleep(3000);

        List<WebElement> modals = driver.findElements(By.id("modal"));

        if (!modals.isEmpty()) {
            modals.get(0).findElement(By.className("close-button")).click();
        }

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("XLE Premium", Keys.ENTER);



Thread.sleep(5000);
//driver.quit();




    }
}
