package theinternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC09_ContextMenuTest {
    /*
            Right click - Context menu
        1.Open browser

        2.Navigate to https://the-internet.herokuapp.com/context_menu

        3.Right click on square box

        4.The context menu is displayed
     */
    @Test
    void clickRightClick() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);

        WebElement box = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(box).perform();

    }

    @Test
    void contextClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Assert.assertEquals(wait.until(ExpectedConditions.alertIsPresent()).getText(), "You selected a context menu");

        driver.switchTo().alert().accept();
        driver.quit();
    }

}
