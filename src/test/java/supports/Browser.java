package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
/*
    Selenium Owner Methods
 */

public class Browser {
    private static WebDriver driver;
    private static int MAX_TIMEOUT_SECOND = 20;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void launchBrowser(String name) {
        switch (name) {
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "Firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "Edge": {
                driver = new EdgeDriver();
                break;
            }
            case "Safari": {
                driver = new SafariDriver();
                break;
            }
            default:
                throw new IllegalCallerException("Unexpected Browser: " + name);
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT_SECOND));
        //actions = new Actions(driver);
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void visit(String url) {
        driver.get(url);
    }

    public static void click(By locator) {
        driver.findElement(locator).click();
    }

    public static void fill(By locator, CharSequence... withText) {
        driver.findElement(locator).sendKeys(withText);
    }

    public static String getText(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIMEOUT_SECOND));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public static void check(By locator) {
        if (!isSelected(locator)) {
            click(locator);
        }
    }

    public static void uncheck(By locator) {
        if (isSelected(locator)) {
            click(locator);
        }
    }

    public static boolean isSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }

    public static boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public static void hover(By locator) {
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void dragDrop(By source, By target) {
        actions.dragAndDrop(getElement(source), getElement(target)).perform();
    }

    public static void captureScreenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static byte[] captureScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        return takesScreenshot.getScreenshotAs(OutputType.BYTES);

    }

    public static List<WebElement> all(By locator) {
        return driver.findElements(locator);
    }

}