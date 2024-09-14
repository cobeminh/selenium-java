package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_NestedFrameTest {
    /*
        1.Open browser
        2.Navigate to https://the-internet.herokuapp.com/nested_frames
        3.Verify Text present:
        4.Copy
                  LEFT
                  RIGHT
                  MIDDLE
                  BOTTOM
     */
    @Test
    void verifyFrameContent() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("LEFT"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("RIGHT"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("BOTTOM"));

        driver.quit();
    }
}
