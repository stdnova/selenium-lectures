package day1;

import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseUsingTestNGAnnotation {

    @Test
    public void testCase001() {

        WebDriver driver = null;

        try {

            driver = new ChromeDriver();
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

            String expectedTitle = expectedTerm + " - Google Search";
            String actualTitle = driver.getTitle();

//        if (actualTitle.contains(expectedTerm)) {
//            System.out.printf("PASS");
//        } else {
//            throw new AssertionError("Test failed. The actual title was: " + actualTitle + " The expected term: " + expectedTerm);
//        }

            Assert.assertEquals(actualTitle, expectedTitle);
            Assert.assertTrue(actualTitle.contains(expectedTerm));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testCase002() {

        WebDriver driver = null;

        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://www.google.com/");

            WebElement searchBar = driver.findElement(By.name("q"));
            String expectedTerm = "Dragon";
            searchBar.sendKeys(expectedTerm, Keys.ENTER);

            //chained version
            // driver.findElement(By.name("q")).sendKeys(expectedTerm, Keys.ENTER);

            String expectedTitle = expectedTerm + " -Google Search";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, expectedTitle);

        } finally {
            driver.quit();
        }
    }

}
