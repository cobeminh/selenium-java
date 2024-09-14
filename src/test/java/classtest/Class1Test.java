package classtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


public class Class1Test {
    private static final Logger logger = LogManager.getLogger("Class1Test");


    @BeforeSuite
    void beforeSuite(){
        logger.info("BeforeSuite::Class1Test");
//        logger.info("BeforeSuite::Class1Test");
    }

    @BeforeTest
    void beforeTest(){
        logger.info("BeforeTest::Class1Test");
    }

    @BeforeClass(alwaysRun = true)
    void beforeClass(){
        logger.info("BeforeClass::Class1Test");
    }

    @BeforeMethod
    void beforeMethod(){
        logger.info("BeforeMethod::Class1Test");
    }

    @BeforeGroups(groups = {"smoke-test"})
    void beforeGroup(){
        logger.info("Before Group");
    }
    @Test
    void tc01(){
        logger.info("Class1Test::tc01");
        logger.error("failed by not found element");
    }

    @Test(groups = {"smoke-test"})
    void tc02(){
        logger.info("Class1Test::tc02");
    }

    @Test(groups = {"smoke-test"})
    void tc03(){
        logger.info("Class1Test::tc03");
    }
    @Test(groups = {"wip"})
    void tc04(){
        logger.info("Class1Test::tc04");
    }
    @Test
    void tc05(){
        logger.info("Class1Test::tc05");
    }
    @AfterMethod
    void afterMethod(){
        logger.info("AfterMethod::Class1Test");
    }

    @AfterClass
    void afterClass(){
        logger.info("AfterClass::Class1Test");
    }

    @AfterTest
    void afterTest(){
        logger.info("AfterTest::Class1Test");
    }

    @AfterSuite
    void afterSuite(){
        logger.info("AfterSuite::Class1Test");
    }

}