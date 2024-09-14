package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class edgeBrowserTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");

        Assert.assertEquals(driver.getTitle(), "Selenium");

        driver.quit();
    }


}
