package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeWebTablesDynamic {

    @Test
    public void testCase() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://oilprice.com/oil-price-charts/#prices");

        Thread.sleep(2000);

        driver.findElement(By.xpath("(//td[@colspan='6'][.='Click Here for 150+ Global Oil Prices '])[1]//child::a")).click();

driver.quit();

    }
}
