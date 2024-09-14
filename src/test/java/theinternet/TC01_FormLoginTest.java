package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TC01_FormLoginPage;

import static supports.Browser.quit;

public class TC01_FormLoginTest {
    /*
        1.Open browser
        2.Navigate to https://the-internet.herokuapp.com/login
        3.Fill in username with tomsmith
        4.Fill in the password with SuperSecretPassword!
        5.Click on Login button
        6.And the home page is appear
     */

    @Test
    void withValidCredentials() {
        //1.
        WebDriver driver = new ChromeDriver(); //mở chrome
        //2.
        driver.get(" https://the-internet.herokuapp.com/login"); //mở link
        //3.
        /*
         *TAG: input
         * Atribute: E=tagName, A=Atribute name, t=Atribute value,  text=I
         *   css: [A=t]              ||E[A=t]                       xpath://*[@A='t']          ||//E[@A='t']
         *    [type=text]            ||input[type=text]            //*[@type='text']           ||//input[@type='text']
         *   [id=username]           ||input[id=username]          //*[@id='username']         ||//input[@id='username']
         *   [name=username]         ||input[name=username]        //*[@name='username']       ||//input[@name='username']
         * text=n/a                                                 //E[.='I'
         */
        //order(ngắn nhất) id>>tag>>name>>css>xpath
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // 15 cách truyền value 'tomsmith' vào username
        /*
        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("username")).sendKeys("tomsmith");

        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[type=text]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");

        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
*/
        //4.
        /*
         *tag:input
         * Atribute:
         *   type=password
         *   id=password
         *   name=password
         * text: n/a(trống)
         */
        //order(ngắn nhất) id>>name>>css>xpath ~thứ tự ưu tiên của selenium
        // k dùng đc tagname vì selenium sẽ tương tác với tagname đầu tiên mà nó tìm thấy, nên thay vì điền tt vào password thì nó sẽ điền tt vào username
        //14 cách tuong tu tru tagName
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //5.
        /*  atribute cụ thể giúp hình dung đc đối tượng rõ ràng >> nên bỏ những atribute chung chung k cần thiết, ở đây là class='radius'
         *tag:button
         * Atribute:
         *   class=radius
         *   type=submit
         * text: ' Login'
         */
        //order(tương tác với locator rõ ràng, có nghĩa cụ thể): xpath>>cac cach con lai
        driver.findElement(By.xpath("//button[contains(.,' Login')]")).click();
        //8 cách click Login button
        /*
        driver.findElement(By.className("radius")).click();
        driver.findElement(By.cssSelector(".radius")).click();
        driver.findElement(By.xpath("//*[@class='radius']")).click();
        driver.findElement(By.cssSelector("button.radius")).click();
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//*[.=' Login']")).click();
        driver.findElement(By.xpath("//button[contains(.,' Login')]")).click();
         */
        /* top order
        1. chạy đc,
        2. locator rõ ràng
        3.ngắn nhất
         */

        //6.
        /*
         *tag: div
         * Atribute:
         *   class=flash sucess
         * text: na
         */
        //Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
    }


    WebDriver driver;

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver(); //mở chrome
        driver.get(" https://the-internet.herokuapp.com/login");
    }

    @DataProvider
    Object[][] credentialsData() {
        return new Object[][]{
                {"2nam.lhn", "SuperSecretPassword!", "https://the-internet.herokuapp.com/login", "error", "Your username is invalid!"},
        };
    }

    @Test(dataProvider = "credentialsData")
    public void loginFailByWrong(String username, String password, String expectedUrl, String expectedMessageType, String expectedMessage) {
        TC01_FormLoginPage formLoginPage = new TC01_FormLoginPage();
        formLoginPage.open();
        formLoginPage.login(username, password);
        Assert.assertTrue(driver.findElement(By.className(expectedMessageType)).getText().contains(expectedMessage));


    }

    @AfterMethod
    void closeBrowser() {
        quit();
    }

    /*
        @DataProvider
        Object[][] invalidCredentialsData() {
            return new Object[][]{
                    {"2nam.lhn", "SuperSecretPassword!", "Your username is invalid!"},
                    {"tomsmith", "09042003", "Your password is invalid!"},
            };
        }
        @Test(dataProvider = "invalidCredentials")
        public void loginFailByWrong(String username, String password, String expectedMessage) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id='login']/button")).click();

            Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
            Assert.assertTrue(driver.findElement(By.className("error")).getText().contains(expectedMessage));

            driver.quit();
        }
     */
/*
    @Test
    void loginFailByWrongPassword(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("09042003");
        driver.findElement(By.xpath("//*[@id='login']/button")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));

        driver.quit();
    }
 */
    @Test
    void loginSuccessfullyWithValidCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");// basic authentication(//uname:password@domain)

        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("Congratulations! You must have the proper credentials."));

        driver.quit();
    }

}
