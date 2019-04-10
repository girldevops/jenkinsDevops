package android.Framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FatimaZahra on 08/03/2017.
 */
public class ExtentReportManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    private static ExtentTest test;
    private static String filePath = "./test-output/html-report/extentreport.html";

    public static ExtentReports GetExtent(){
        if (extent != null)
            return extent; //avoid creating new instance of html file
        extent = new ExtentReports();
        extent.attachReporter(getHtmlReporter());
        return extent;
    }

    public static ExtentHtmlReporter getHtmlReporter() {

        htmlReporter = new ExtentHtmlReporter(filePath);
        // make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Test Automation Report");
        htmlReporter.config().setReportName("Android Prod Functional Testor Test Report");
        return htmlReporter;
    }
    public static ExtentTest createTest(String name, String description){
        test = extent.createTest(name, description);
        return test;
    }

    //Creating a method getScreenshot and passing two parameters
    //driver and screenshotName
    public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat ("yyyyMMddhhmmss").format(new Date ());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/test-output/html-report/screenshots/"+screenshotName+dateName+".png";

        System.out.print (destination);

        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        // Set the source image path in html report
        String imageSrc= "./screenshots/"+screenshotName+dateName+".png";
        //Returns the  source image path  file path to be used by th html  report
        return imageSrc;
    }
}
