package theinternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC08_InteractionTest {
    WebDriver driver;

    @Test
    void hoverTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//div[@class='figure'][2]"));

        action.moveToElement(user1).perform();//hover
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='figure'][2]/div[@class='figcaption']")).isDisplayed());
    }

    @Test
    void dragDropTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(source, target).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("column-a header")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.cssSelector("column-b header")).getText().contains("A"));

        driver.quit();
    }

    @Test
    void horizontalSliderTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement input = driver.findElement(By.cssSelector(".sliderContainer input"));

        int width = input.getSize().getWidth();
        actions.clickAndHold(input).moveByOffset(width, 0).perform();

        Assert.assertEquals(driver.findElement(By.id("range")).getText(), "5");

    }

    @Test
    void keyPressTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.ESCAPE).perform();
    }

    @Test
    void scrollTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 100000).perform();
            Thread.sleep(1000);
        }
    }

    @Test
    void contextClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

    }

    @Test
    void captureScreenShot() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
