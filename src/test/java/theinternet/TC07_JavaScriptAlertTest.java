package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC07_JavaScriptAlertTest {
    /*
        1. Open browser

        2. Navigate to https://the-internet.herokuapp.com/javascript_alerts

        3. When click on "Click For JS Alert" button

        4. Then the Popup is displayed.
      */
    WebDriver driver;

    @BeforeMethod
    void open() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void closeJSAlert() {
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();//ok

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();//cancel
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You clicked: Cancel"));

        driver.quit();
    }

    @Test
    void clickToSendKeyJsPrompt() {
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: hello");
    }

}