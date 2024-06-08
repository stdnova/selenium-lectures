package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumBasic {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        System.out.println(currentUrl);
        System.out.println(title);

      //  System.out.println(driver.getPageSource());

        if (driver.getPageSource().contains("Selenium automates browsers. That's it!") ) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test failed");
        }

        Thread.sleep(3000);

        driver.navigate().to("https://www.duotech.io/");
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.quit();

    }
}
