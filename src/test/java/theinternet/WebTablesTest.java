package theinternet;


import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.TC05_WebTablesPage;
import supports.Browser;

import java.util.List;

import static supports.Browser.*;

public class WebTablesTest {

    TC05_WebTablesPage webTablesPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        launchBrowser(browser);
        webTablesPage = new TC05_WebTablesPage();
        webTablesPage.open();
        webTablesPage.getTable();
    }

    @Feature("Web table")
    @Story("Find max due Person")
    @TmsLink("TC05")
    @Test
    void verifyMaxDuePerson() {
        Assert.assertEquals(
                webTablesPage.getMaxDuePerson().stream().map(Person::getFullname).toList(), List.of("Doe Jason")
        );
    }

    @Feature("Web table")
    @Story("Find min due Person")
    @Test
    void verifyMinimumDuePerson() {
        Assert.assertEquals(
                webTablesPage.getMinDuePerson().stream().map(Person::getFullname).toList(), List.of("Smith John", "Conway Tim")
        );
    }

    @Attachment(type = "image/png")
    private byte[] createAttachment(){
        return captureScreenShot();
    }

    @AfterMethod
    void captureScreen(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            Browser.captureScreenShot(iTestResult.getMethod().getMethodName());
            createAttachment();
        }
    }

    @AfterClass
    void closeBrowser() {
        quit();
    }

}
