package day3;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class XpathAdvanced {

    @Test
    public void testCase() {

       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       driver.get("https://www.carfax.com/");

       driver.findElement(By.linkText("Used Car Values")).click();

       //locate all a's with class attribute
       //  //a[@class]
       //  //a[not(@class)] (all a's without class attribute)

        // through unique parent (ancestor)
        //div[@class='text-input vehicleInputFormStyle_vehicle-input-form__input__plate__gCjxu']//input[@type='text']

        driver.findElement(By.xpath("//div[@class='text-input vehicleInputFormStyle_vehicle-input-form__input__plate__gCjxu']//input[@type='text']")).
                sendKeys("TKU2342", Keys.ENTER);

        Random random = new Random();
        StringBuilder vinSb = new StringBuilder();
        // VIN is 17 characters long, can include digits (0-9) and letters (A-Z) except I, O, Q
        String vinChars = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        for (int i = 0; i < 17; i++) {
            vinSb.append(vinChars.charAt(random.nextInt(vinChars.length())));
        }
        String vin = vinSb.toString();


        // exact text //h2[.='Step 2 - Enter your VIN or License Plate']
        // . = text()

        // locate a non-unique parent by its unique CHILD
        // syntax -> //childLocator/parent::tagName
        //h2[contains(., 'Step 2 - Enter your VIN')]//parent::form

       // System.out.println(driver.findElement(By.xpath("//h2[contains(., 'Step 2 - Enter your VIN')]//parent::form")).getText());

        // locate a non-unique by its unique sibling that comes after it
        // syntax -> // uniqueSibling//preceding-sibling::input

//label[.='Vehicle Identification Number']//preceding-sibling::input or
// label[.='Vehicle Identification Number']//preceding-sibling::input[@type='text']


driver.findElement(By.xpath("//label[.='Vehicle Identification Number']//preceding-sibling::input")).
        sendKeys(vin);


    }
}
