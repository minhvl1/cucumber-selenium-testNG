package runners;
import cucumberHooks.CucumberListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.EmailSendUtils;

import java.io.File;


@Test
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"Steps","cucumberHooks"},
        plugin = {"cucumberHooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber-reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
         monochrome = true,
        tags = "@Feature1 or @Feature2"
)

public class TestRunnerAllFeatures extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

//    @Override
//    public void tearDownClass(){
//    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("================ AFTER SUITE ================");
        EmailSendUtils.sendEmail(CucumberListener.count_totalTCs
                , CucumberListener.count_passedTCs
                , CucumberListener.count_failedTCs
                , CucumberListener.count_skippedTCs);
    }
    @BeforeSuite
    public void deleteScreenshotsFiles(){
        try {
            System.out.println("================ BEFORE SUITE ================");
//            String workingDir = System.getProperty("user.dir");
            String pathFolderextent = "allure-results";
            File file = new File(pathFolderextent);
            File[] listOfFiles = file.listFiles();
            System.out.println("......................"+pathFolderextent);
            for(int i = 0; i < listOfFiles.length; i++){
                if(listOfFiles[i].isFile()){
                    new File(listOfFiles[i].toString()).delete();
                }
            }
            System.out.println("================ DELETE ================");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
