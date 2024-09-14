package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v126.emulation.Emulation;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.performance.Performance;
import org.openqa.selenium.devtools.v126.performance.model.Metric;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class chromeBrowserTest {
    @Test
   /* mở Google Chrome
    void openWithDefaultMode(){
        new ChromeDriver();
    }
     */

    void openWithDefaultMode() {
        WebDriver driver = new ChromeDriver(); //mở chrome
        driver.get("https://www.selenium.dev/"); //mở link

        Assert.assertEquals(driver.getTitle(), "Selenium");//kiem tra title link co trùng

        driver.quit(); //đóng link
    }


    @Test
    void openWithHeadlessMode() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");

        Assert.assertEquals(driver.getTitle(), "Selenium");

        driver.quit();
    }

    @Test
    void openWithMobileViewPort() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 412);
        deviceMetrics.put("height", 915);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev");
        driver.get("https://www.selenium.dev/");

        Assert.assertEquals(driver.getTitle(), "Selenium");
    }

    @Test
    void fakeGeoLocation() {
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(20.6165707),
                Optional.of(106.4713166),
                Optional.of(19.23)));
        driver.get("https://the-internet.herokuapp.com/geolocation");

        driver.findElement(By.xpath("//button[.='Where am I?']")).click();
    }

    @Test
    void openBrowserWithOldVersion() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("115");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev");

        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void interceptionNetwork() {
        WebDriver driver = new ChromeDriver();
        DevTools devTool = ((HasDevTools) driver).getDevTools();

        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//filter nhung url selenium.dev
        devTool.addListener(Network.requestWillBeSent(), requestSent -> {
            if (requestSent.getRequest().getUrl().contains("selenium.dev")) {
                System.out.println("Request URL => " + requestSent.getRequest().getUrl());
                System.out.println("Request Method => " + requestSent.getRequest().getMethod());
                System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
                System.out.println("------------------------------------------------------");
            }
        });

        devTool.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response Url => " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceived.getResponse().getHeaders().toString());
            System.out.println("Response MIME Type => " + responseReceived.getResponse().getMimeType().toString());
            System.out.println("------------------------------------------------------");
        });

        driver.get("https://selenium.dev");
    }

    @Test
    void captureWebPerformanceMetrics(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        driver.get("https://www.google.org");

        List<Metric> metrics = devTools.send(Performance.getMetrics());
        List<String> metricNames = metrics.stream()
                .map(o -> o.getName())
                .collect(Collectors.toList());

        devTools.send(Performance.disable());

        List<String> metricsToCheck = Arrays.asList(
                "Timestamp", "Documents", "Frames", "JSEventListeners",
                "LayoutObjects", "MediaKeySessions", "Nodes",
                "Resources", "DomContentLoaded", "NavigationStart");

        metricsToCheck.forEach( metric -> System.out.println(metric +
                " is : " + metrics.get(metricNames.indexOf(metric)).getValue()));
        driver.get("https://selenium.dev");
    }
}
