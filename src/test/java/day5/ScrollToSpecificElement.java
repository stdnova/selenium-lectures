package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollToSpecificElement {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.duotech.io/");

        WebElement webELement = driver.findElement(By.xpath("//a[.='Enroll Now']"));

        int verticalLocation = webELement.getLocation().getY(); // vertical location is Y ^
        System.out.println(verticalLocation);
        Thread.sleep(3000);

        ( (JavascriptExecutor) driver).executeScript( "window.scrollBy(0, "+verticalLocation+")" );
        Thread.sleep(3000);

        ( (JavascriptExecutor) driver).executeScript( "window.scrollBy(0, -5805)" );
        Thread.sleep(3000);


        // //a[@href='/software-qa-engineer'][@class='button w-button'] same as //h1
        SeleniumUtils.scrollToWebElement(driver, driver.findElement(By.xpath("//h2[.='Benefits of becoming SQAE']")));


        Thread.sleep(5000);
        driver.quit();

    }

}

