package com.sg.cloud;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZDemo3_CloudSauceAppTest2022 {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	      
	      // Set your access credentials
	      caps.setCapability("browserstack.user", "dinakaranbalaji1");
	      caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");
	      
	      // Set URL of the application under test
	      caps.setCapability("app", "bs://52639577abc830ff370ce647f3bb1cd4462f1922");
	      
	      // Specify device and os_version for testing
	      caps.setCapability("device", "iPhone 11 Pro");
	      caps.setCapability("os_version", "13");
	        
	      // Set other BrowserStack capabilities
	      caps.setCapability("project", "Syn");
	      caps.setCapability("build", "Java iOS-NEW2022");
	      caps.setCapability("name", "first_test");
	      
	      
	      // Initialise the remote Webdriver using BrowserStack remote URL
	      // and desired capabilities defined above
	        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
	            new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
	        

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@name='test-Username']").sendKeys("standard_user");
		driver.findElementByXPath("//*[@value='Password']").sendKeys("secret_sauce");
		driver.findElementByXPath("//XCUIElementTypeOther[@name='test-LOGIN']").click();
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='test-ADD TO CART']")));
		
		driver.findElementByXPath("//*[@name='test-ADD TO CART']").click();
		driver.findElementByXPath("//*[@name='test-ADD TO CART']").click();
		driver.findElementByXPath("//*[@name='test-ADD TO CART']").click();
		driver.findElementByXPath("//*[@name='test-ADD TO CART']").click();
		
//		driver.findElementByXPath("(//XCUIElementTypeOther[@name='1'])[4]").click();

		driver.findElementByXPath("//XCUIElementTypeOther[@name='test-Cart']").click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@name='YOUR CART']")));
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		System.out.println(driver.findElementsByXPath("//*[contains(@name,'test-CHECKOU')]").size());
		System.out.println(driver.findElementByXPath("//*[contains(@name,'test-CHECKOU')]").isDisplayed());
		
		while(!driver.findElementByXPath("//*[contains(@name,'test-CHECKOU')]").isDisplayed())
		{
			driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[contains(@name,'test-CHECKOU')]").click();
		
		System.out.println(driver.getPageSource());
		
		driver.quit();
	}

}