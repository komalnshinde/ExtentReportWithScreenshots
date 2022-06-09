package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import base.baseClass;

public class commonFunctions extends baseClass {
	public static WebDriver driver;
	
	public void clickByXpath(By locator) {
	
		try {
	      super.driver.findElement(locator).click();
		}
		catch(ElementNotFoundException e){
			System.out.println("Elemenet Not Found Exception :" + locator);
			
		}
		catch(NoSuchElementException e ) {
			System.out.println("No Such Element Exception :" + locator);
		}
	}
	
	public void setTest(By locator, String testData) {
		try {
		    driver.findElement(locator).sendKeys(testData);
		}
		catch(ElementNotFoundException e){
			System.out.println("Elemenet Not Found Exception :" + locator);
			
		}
		catch(NoSuchElementException e ) {
			System.out.println("No Such Element Exception :" + locator);
	    }
		
		
	}
		
		
	

}
