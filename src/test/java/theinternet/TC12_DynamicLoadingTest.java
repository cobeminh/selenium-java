package theinternet;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC12_DynamicLoadingTest {
    @Test
    void waitForResult() throws InterruptedException {
        /*
            1.Open browser
            2.Navigate to https://the-internet.herokuapp.com/dynamic_loading/1
            3.Click on Start button
            4.Wait process bar disappear
            5.Check finish message
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String result = wait
                .until(
                        ExpectedConditions
                                .visibilityOfElementLocated(By.cssSelector("#finish h4")))
                .getText();

        Assert.assertEquals(result, "Hello World!");
    }
}
