package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDemo {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.dice.com/");

        WebElement searchBar = driver.findElement(By.id("typeaheadInput"));

Actions actions = new Actions(driver);

// actions.keyDown(Keys.SHIFT).sendKeys(searchBar, "sdet").keyUp((Keys.SHIFT)).sendKeys(searchBar, " qa").build().perform(); //build() is optional

actions.keyDown(Keys.SHIFT).sendKeys(searchBar, "sdet").keyUp((Keys.SHIFT)).sendKeys(searchBar, " qa").perform();

//new Actions(driver).keyDown(Keys.COMMAND).click(driver.findElement(By.linkText("Project Manager"))).perform();


        SeleniumUtils.scrollBy(driver, 0, 5000);

        Thread.sleep(2000);
        actions.keyDown(Keys.LEFT_SHIFT).click(driver.findElement(By.linkText("Project Manager"))).perform();
       // actions.keyDown(Keys.COMMAND).click(driver.findElement(By.linkText("Project Manager"))).perform();

        /**
        tis combination of actions to use for key shift, and JS to click won't work as it needs to be built together in a chain

         actions.keyDown(Keys.LEFT_SHIFT).build().perform();
         SeleniumUtils.jsClick(driver, driver.findElement(By.linkText("Project Manager")));
         */


     // Thread.sleep(4000);
     // driver.quit();


    }

}

