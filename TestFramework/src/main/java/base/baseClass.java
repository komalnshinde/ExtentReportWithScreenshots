package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {
	public Properties properties;
	public static WebDriver driver;
	
	
	public void loadPropertiesFile() {
		 properties = new Properties();
		 try {
		FileInputStream fin =  
				new FileInputStream(System.getProperty("user.dir") + File.separator +"src" 
		+ File.separator + "test" + File.separator + "resources" + File.separator + "data.properties");	
		properties.load(fin);
			 
		 }
		 catch(FileNotFoundException e) {
			 System.out.println("File Not Found Exception : ");
		 }
		 catch(IOException e) {
			e.getMessage(); 
		 }

	}
	
	public WebDriver initializeWebdriver() {
		loadPropertiesFile();
	    driver = new ChromeDriver();
	    System.out.println("Created webdriver object");
		System.setProperty("webdriver.chrome.driver", "./drivers.chromedriver.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		String browserUrl= properties.getProperty("url");
//		System.out.println("Enter URL :" + browserUrl);
//		driver.get(browserUrl);
		return driver;
		
	}
	public void enterURI() {
		String browserUrl= properties.getProperty("url");
		System.out.println("Enter URL :" + browserUrl);
		driver.get(browserUrl);
		
	}
	
	public void closeBrowser() {
		System.out.println("Closing browser");
		driver.close();
		System.out.println("Closed browser");
	}
	
//	public void addScreenshot(@Test test) {
//		TakesScreenshot screenshot = ((TakesScreenshot)driver);
//		final byte [] screenshots= screenshot.getScreenshotAs(OutputType.BYTES);
//	}
	

}
