package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HandlingWindows {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.volvo.com/en/");
        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//img[@alt='Cars']")).click();

        System.out.println("Before switching the window: " + driver.getTitle());

        // SWITCH TO A WINDOW
// if you don't switch to the other window/tab you will get the following exception
//NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//button[.='Accept']"}

        String firstWindowsHandle = driver.getWindowHandle(); // get the id of the currently active window
        System.out.println("First window's handle: " + firstWindowsHandle);

        Set<String> windowHandles = driver.getWindowHandles(); // gets the handles of all open windows/tabs
        System.out.println("All window handles: " + windowHandles);

        for (String windowHangle : windowHandles){
            if(!windowHangle.equals(firstWindowsHandle)) {
                driver.switchTo().window(windowHangle);
            }
        }

        System.out.println("After switching the window: " + driver.getTitle());

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Accept']")).click();
        Thread.sleep(1000);

        //SWITCH BACK TO FIRST WINDOW
        driver.switchTo().window(firstWindowsHandle);

        System.out.println("After switching back to the original window: " + driver.getTitle());


      //  driver.close(); //closes the current tab/window
        driver.quit(); // ends the entire current session, no browser will be closed

    }


    }
