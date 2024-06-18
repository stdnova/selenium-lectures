package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils {

    public static WebElement locateByDataTestIdSingle (WebDriver driver, String elementName, String elementValue){

        return driver.findElement(By.xpath("//" + elementName + "[@data-testid='" +elementValue +"']"));
    }

    public static List<WebElement> locateByDataTestIdMultiple (WebDriver driver, String elementName, String elementValue){

        return driver.findElements(By.xpath("//" + elementName + "[@data-testid='" +elementValue +"']"));
    }

    public static List<String> getElementsText(List<WebElement> list){
        List<String> actual = new ArrayList<>();
        list.forEach( s -> actual.add(s.getText() ) );

//        for (WebElement element : list) {
//            actual.add(element.getText());
//        }

        return actual;
    }


}
