package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class FileUpload {

    @Test
    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // works for location operation, findElement

        driver.get("https://www.file.io/");

        String pathToCurrentFolder = System.getProperty("user.dir"); ///Users/kmammadli/IdeaProjects/selenium-lectures
        System.out.println(pathToCurrentFolder);

        //locate the input element with the type attribute file and sendKeys the full path to the file
      //  driver.findElement(By.id("upload-button")).sendKeys("/Users/kmammadli/Desktop/IO practice/hello.txt");

        driver.findElement(By.id("upload-button")).sendKeys(System.getProperty("user.dir") + "/src/test/java/day6/screenshot.png");

        System.out.println(System.getProperty("user.dir") + "/src/test/java/day6/screenshot.png");

//        Robot robot = new Robot();
//        robot.mouseMove(200,500);

        ChromeOptions options = new ChromeOptions(); // to predefine folder for downloading


    }

}
