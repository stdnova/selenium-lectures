package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo2 {

    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // dynamic wait (implicit wait provided by Selenium)

        driver.get("https://www.webstaurantstore.com/");

        System.out.println(driver.findElement(By.xpath("//button[@type='submit'][@value='Search']")));

//   //button[@type='submit' and @value='Search']
//   //button[@type='submit' or @value='Search']
//   //button[@type] -> all button elements with type attribute, all elements that have ID values for example
//   //*[@id] -> any element with id attribute
//   //*[@*] -> any element with any attribute
//   //* -> any element


//   //div[.='Ice & Water Dispensers'] -> div with a text full
//   //div[text()='Ice & Water Dispensers'] -> div with a text full

//   //div[contains(text(), 'Versatile Hydration')] -> div with a partial text (to match)

        System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Versatile Hydration')]")).getText());


        //Predicate
//   (xpathExpression) [number]
//   (//div[@class='group-hover:'])[2] -> matches the second of the possible matches

        System.out.println(driver.findElement(By.xpath("(//div[@class='group-hover:underline !leading-[1.1] line-clamp-2 " +
                "text-ellipsis font-bold text-base xsl:text-lg md:text-base lt:text-lg xxxl:text-xl pt-3 xsl:pt-4 xs:pt-6 md:pt-3 " +
                "lt:pt-4 lz:pt-6 [text-wrap:balance]'])[2]")).getText());

        driver.quit();

    }
}
