package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class CheckboxesRadioWithLoop {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB,
                "test", Keys.ENTER);

        List<WebElement> elements = driver.findElements(By.cssSelector("input[type='checkbox']"));


        for (WebElement element : elements) {
            if (!element.isSelected()){
                element.click();
            }
        }

        driver.findElement(By.cssSelector(".btnDeleteSelected")).click();

        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

        driver.findElement(By.cssSelector("input[value='MasterCard']")).click();

        List<WebElement> radioList = driver.findElements(By.cssSelector("input[type='radio']"));

        for (WebElement button : radioList) {
            Random rand = new Random();
            radioList.get(rand.nextInt(radioList.size())).click();
        }

        Thread.sleep(3000);
driver.quit();
    }

    }
