package PageClasses;

import java.io.IOException;

import org.apache.http.util.Asserts;
import org.bson.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.commonFunctions;
import base.baseClass;

public class LoginPage extends baseClass{
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	

	commonFunctions commonFunctions = new commonFunctions();

	
	By btnLogin = By.xpath("//p[text()='LOGIN / SIGNUP'][2]/");
	
	By btnContinue = By.xpath("//input[@value='Continue']");
	By inpMobileNumber = By.xpath("//input[@name='phone']");
	
	By link = By.xpath("//a[text()='Flights']");
	
	
	public void clickLoginButton() {
		commonFunctions.clickByXpath(btnLogin);
		
	}
	
	public void launchURL(){
		System.out.println("Calling Initialise Webdriver method of Base Class");
		
    initializeWebdriver();
    enterURI();
	}
	
	
			

}
