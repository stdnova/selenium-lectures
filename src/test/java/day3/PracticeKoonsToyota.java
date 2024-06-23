package day3;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class PracticeKoonsToyota {

    @Test
    public void testCase() throws InterruptedException, IOException {

            WebDriver driver = null;

            try {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

                driver.get("https://www.koonstoyotatysonscorner.com/");
                Thread.sleep(1000);

                Select typeDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterType']")));
                Assert.assertEquals(typeDropdown.getFirstSelectedOption().getText(), "All");
                typeDropdown.selectByVisibleText("New");
                Thread.sleep(1000);

                Select makeDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterMakes']")));
                Assert.assertEquals(makeDropdown.getFirstSelectedOption().getText(), "Toyota");
                makeDropdown.selectByVisibleText("Toyota");
                Thread.sleep(1000);

                Select modelDropdown = new Select(driver.findElement(By.cssSelector("select[id='searchByFilterModels']")));
                Assert.assertEquals(modelDropdown.getFirstSelectedOption().getText(), "Any Model");
                modelDropdown.selectByVisibleText("RAV4");
                Thread.sleep(1000);

                driver.findElement(By.cssSelector("button[class='search-by-filter__search-button desktop btn stat-button-link']")).click();
                Thread.sleep(1000);

                try {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    WebElement topElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#engagement-container-131138")));

                    if (driver.findElement(By.cssSelector("div#engagement-container-131138")).isEnabled()){
                        System.out.println("there is a pop up during this test");
                    }

                    SearchContext shadowRoot = topElement.getShadowRoot();
                    shadowRoot.findElement(By.cssSelector("#ip-no")).click();

                } catch (TimeoutException e) {
                    System.out.println("no pop up during this test");
                }

                driver.findElement(By.cssSelector("input[id$='-input-desktop'")).sendKeys("XLE Premium", Keys.ENTER);

            } catch (Exception e){

                File screenshotfile = ( (TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshotfile, new File("src/test/java/day3/screenshotKoons.png"));

            } finally {

                Thread.sleep(1000);
                if (driver != null) {
                    driver.quit();
                }

            }


    }
}
