package classtest;

import org.testng.annotations.*;

public class Class2Test {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("BeforeSuite::Class2Test");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("BeforeTest::Class2Test");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("BeforeClass::Class2Test");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("BeforeMethod::Class2Test");
    }

    @Test(groups = {"smoke-test"})
    void tc01() {
        System.out.println("Class2Test::tc01");
    }

    @Test
    void tc02() {
        System.out.println("Class2Test::tc02");
    }

    @Test
    void tc03() {
        System.out.println("Class2Test::tc03");
    }

    @Test
    void tc04() {
        System.out.println("Class2Test::tc04");
    }

    @Test(groups = {"smoke-test"})
    void tc05() {
        System.out.println("Class2Test::tc05");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("AfterMethod::Class2Test");
    }

    @AfterClass
    void afterClass() {
        System.out.println("AfterClass::Class2Test");
    }

    @AfterTest
    void afterTest() {
        System.out.println("AfterTest::Class2Test");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("AfterSuite::Class2Test");
    }
}
