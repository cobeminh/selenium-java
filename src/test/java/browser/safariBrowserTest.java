package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class safariBrowserTest {
    @Test
    void openWithDefaultMode() {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.selenium.dev/");

        Assert.assertEquals(driver.getTitle(), "Selenium");

        driver.quit();
    }

}
