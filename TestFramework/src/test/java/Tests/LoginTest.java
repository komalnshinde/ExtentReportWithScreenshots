package Tests;

import java.io.IOException;

import org.eclipse.jetty.http.HttpGenerator.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;

import PageClasses.LoginPage;
import base.baseClass;

public class LoginTest extends baseClass {

//	public ExtentHtmlReporter htmlReporter;
	public ExtentTest extentTest;
	LoginPage loginPage = new LoginPage(driver);
	extendReport extendReport = new extendReport(driver);
//	public ExtentReports extent = new ExtentReports(null);

	@BeforeMethod
	public void launchBrowser() throws IOException {
		System.out.println("Executing Before Method");
		loginPage.launchURL();
	}

	@BeforeTest
	public void setExtent() {
		System.out.println("Executing befort Test");
		extendReport.setExtent();

	}

	@AfterTest
	public void endReport() {
		System.out.println("Executing After Test");
		extendReport.endReport();
	}

	@Test
	public void verifyPageTitle() throws InterruptedException {
		System.out.println("Executing  Test");
		extentTest = extendReport.extent.startTest("verifyPageTitle");
		String title = loginPage.driver.getTitle();
		Thread.sleep(60);
		Assert.assertEquals(title,
				"Free CRM software for customer relationship management, sales, marketing campaigns and support.12");
	}

	@AfterMethod
	public void teadDown(ITestResult result) throws IOException {
		System.out.println("Executing After Method");
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test case FAILED is " + result.getName());
			extentTest.log(LogStatus.FAIL, "Test case FAILED is" + result.getThrowable());

			String screenshotPath = extendReport.getScreenshot(driver, result.getName());
			extentTest.addScreenCapture(screenshotPath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test case Skipped is " + result.getName());
			extentTest.log(LogStatus.SKIP, "Test case Skipped is" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case PASSED is " + result.getName());
			extentTest.log(LogStatus.PASS, "Test case PASSED is" + result.getThrowable());

			String screenshotPath = extendReport.getScreenshot(driver, result.getName());
			extentTest.addScreenCapture(screenshotPath);
		}

		driver.quit();
	}
}
