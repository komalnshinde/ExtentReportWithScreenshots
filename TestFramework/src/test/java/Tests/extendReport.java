package Tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentReports;

import base.baseClass;

public class extendReport extends baseClass {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public extendReport(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Report/extentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report/extentReport.html", true);
//		extent.attachReporter(htmlReporter);

		extent.addSystemInfo("Tester Name", "Komal");
		System.out.println("Added Name on Report");
		
		

	}

	@AfterTest()
	public void endReport() {
		System.out.println("Executing Flush report");
		extent.flush();
		System.out.println("Executed Flush report");
        extent.close();
	}

	public String getScreenshot(WebDriver driver, String screenShotName) throws IOException {
		System.out.println("driver=" + driver);

		String dateName = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/" + screenShotName + dateName
					+ ".png";
			System.out.println(destination + " : destination Path");
			File fileDestination = new File(destination);

			FileUtils.copyFile(source, fileDestination);

			return destination;
		} catch (Exception e) {

		}
		return null;

	}
}
