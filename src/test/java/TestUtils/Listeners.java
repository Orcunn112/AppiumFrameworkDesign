package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReporterObject();

    @Override
    public void onTestStart(ITestResult  result) {

        extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {

            test.log(Status.PASS, "Test Passed");
        }catch (Exception e){

        }
    }

    @Override
    public void onTestFailure(ITestResult  result) {
     test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
         extent.flush();
    }

}
