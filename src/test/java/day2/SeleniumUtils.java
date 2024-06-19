package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static void switchToWindow(WebDriver driver){
        String currentHandle = driver.getWindowHandle();
       // Set<String> currentHandles = driver.getWindowHandles(); can go straight into the loop
        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(currentHandle)){
                driver.switchTo().window(windowHandle);
                return;
            }
        }
    }

    public static void switchToWindowByTitle(WebDriver driver, String title){
        //Set<String> windowHandles = driver.getWindowHandles(); went straight into the loop
        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals(title)){
                break;
            }
        }
    }

    public static void jsClick(WebDriver driver, WebElement elementToClick){
        ( (JavascriptExecutor)driver ).executeScript("arguments[0].click();", elementToClick);
    }

    public static void scrollToWebElement(WebDriver driver, WebElement elementToScroll){
    ( (JavascriptExecutor) driver).executeScript( "window.scrollBy(0, "+elementToScroll.getLocation().getY()+")");
    }


    public static void scrollBy(WebDriver driver, int x, int y){
        ( (JavascriptExecutor) driver).executeScript( "window.scrollBy("+x+", "+y+")");
    }

    public static void waitForPresenceOfAllElements(WebDriver driver, Duration duration, By by){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }


}
