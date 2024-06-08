package day1;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

    public static void main(String[] args) {

// Google Search Functionality
// Pre-requisite: Chrome Browser should be open and maximized

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

// 1. Go to google.com
        driver.get("https://www.google.com/");

// 2. Type a search term and search (e.g dragon)
        //locate the search bar
       WebElement searchBar = driver.findElement(By.name("q"));
       //type the term and hit enter
        String expectedTerm = "Dragon";
        searchBar.sendKeys(expectedTerm, Keys.ENTER);
// 3. On the search results page, verify the title of the page has the same term

        //chained version
        // driver.findElement(By.name("q")).sendKeys(expectedTerm, Keys.ENTER);

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTerm)) {
            System.out.printf("PASS");
        } else {
            throw new AssertionError("Test failed. The actual title was: " + actualTitle + " The expected term: " + expectedTerm);
        }

driver.quit();

    }
}
