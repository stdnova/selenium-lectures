package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class WarmUpTaskFailedTripadvisor {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // End-to-end test -> as a user how would you use this application is a type of integration test

            driver.get("https://www.tripadvisor.com/");
        Thread.sleep(1000);
//        driver.switchTo().frame(0);
//
//        // Add explicit wait to ensure the iframe content is loaded
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='sliderIcon']")));
//
//        // Use Actions class to slide the slider
//        Actions actions = new Actions(driver);
//
//        // Calculate the offset to move the slider to the end
//        int sliderWidth = slider.getSize().getWidth();
//        int xOffset = sliderWidth; // Move the slider to the end
//
//        Thread.sleep(5000);
//        // Move the slider to the end
//        actions.clickAndHold(slider)
//                .moveByOffset(xOffset, 0)
//                .release()
//                .perform();
//
//        Thread.sleep(5000);
//        // Optionally, get the value of the slider to verify
//        System.out.println("Slider value: " + slider.getAttribute("value"));
//
//        // Switch back to the main content
//        driver.switchTo().defaultContent();

            driver.findElement(By.name("q")).sendKeys("Paris", Keys.ENTER);
            Thread.sleep(3000);

            driver.findElement(By.linkText("Paris")).click();

        } finally {
            Thread.sleep(3000);
            driver.quit();
        }




    }
}
