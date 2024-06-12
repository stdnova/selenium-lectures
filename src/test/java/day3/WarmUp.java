package day3;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import java.time.*;

public class WarmUp {

    @Test
    public void testSignUp() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

        Faker faker = new Faker();

        String first = faker.address().firstName();
        String last = faker.address().lastName();
        String email = faker.internet().emailAddress();
        String pass = faker.internet().password(10, 16,
                true, true, true);

        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys(
                first, Keys.TAB,
                last, Keys.TAB,
                email, Keys.TAB,
                pass, Keys.ENTER);

        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains("Registration Successful"));




    }
}
