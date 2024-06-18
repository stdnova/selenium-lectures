package day4;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTables {

    @Test

    public void testCase() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester", Keys.TAB,
                "test", Keys.ENTER);

        driver.findElement(By.linkText("View all products")).click();

        // WORKING WITH ROW DATA

        List<String> expected = List.of("Product name", "Price", "Discount"); // header value requirements, acceptance criteria in user story

        // (//table[not(@border)]//tr)[1] or //table[not(@border)]//tr[1]

//        String text = driver.findElement(By.xpath("//table[not(@border)]//tr[1]")).getText();
//        System.out.println(text);

        List<WebElement> ths = driver.findElements(By.xpath("//table[not(@border)]//tr[1]//th"));

        //extract the text of elements into a list.
//        List<String> actual = new ArrayList<>();
//        ths.forEach( s -> actual.add(s.getText() ) );

        List<String> actual = SeleniumUtils.getElementsText(ths); // SeleniumUtils class is in Day2
        Assert.assertEquals(actual, expected);
        List<String> myMoneyExpected = List.of("MyMoney", "$100", "8%");

        List<WebElement> myMoney = driver.findElements(By.xpath("//table[not(@border)]//tr[2]//td"));
        List<String> myMoneyActual = SeleniumUtils.getElementsText(myMoney);
        Assert.assertEquals(myMoneyActual, myMoneyExpected);

        // WORKING WITH COLUMN DATA

        List<String> expectedProducts = List.of("MyMoney", "FamilyAlbum", "ScreenSaver");
        List<WebElement> elements = driver.findElements(By.xpath("//table[not(@border)]//tr//td[1]"));
        List<String> actualProducts = SeleniumUtils.getElementsText(elements);
        Assert.assertEquals(actualProducts, expectedProducts);

        // FIND ROW AND COLUMN COUNT

        int columnCount = driver.findElements(By.xpath("//table[not(@border)]//tr[1]//th")).size();

        // //table[not(@border)]//tbody//tr - condition all should be trs, not going to work in interation as this table contains ths and tds
        // to ignore th in the first row
        // int rowCount = driver.findElements(By.xpath("//table[not(@border)]//tbody//tr/td/parent::tr")).size();

        int rowCount = driver.findElements(By.xpath("//table[not(@border)]//tbody//tr")).size();

        System.out.println(columnCount);
        System.out.println(rowCount);

        Thread.sleep(5000);
        driver.quit();
    }
}
