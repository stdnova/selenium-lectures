package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingDropdowns {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.carfax.com/");

        driver.findElement(By.linkText("Used Car Values")).click();

        driver.findElement(By.cssSelector("#zip")).sendKeys("22043");
        driver.findElement(By.cssSelector("#plate")).sendKeys("UGA2345");

        WebElement selectElement = driver.findElement(By.cssSelector("#us-state"));
        Select select = new Select(selectElement);

        // select.selectByVisibleText("VA");
        // new Select(driver.findElement(By.cssSelector("#us-state"))).selectByValue("VA"); // options value
        new Select(driver.findElement(By.cssSelector("#us-state"))).selectByIndex(48); //it is 1 based index

//        WebElement checkbox = driver.findElement(By.cssSelector(".checkbox-input_box")); //clicked on the other element that covered input
//
//        if (!checkbox.isSelected()){
//            checkbox.click();
//        }

         driver.findElement(By.cssSelector("button[class='button ripple-container vehicleInputFormStyle_vehicle-input-form__input__submit__4aiwM']")).
         click();


         Thread.sleep(3000);
     //driver.quit();
    }

}
