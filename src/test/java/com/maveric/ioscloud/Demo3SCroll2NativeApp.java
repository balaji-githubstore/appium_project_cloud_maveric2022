package com.maveric.ioscloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

public class Demo3SCroll2NativeApp {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		// Set URL of the application under test
		caps.setCapability("app", "bs://52639577abc830ff370ce647f3bb1cd4462f1922");

		// Specify device and os_version for testing
		caps.setCapability("device", "iPhone 11 Pro Max");
		caps.setCapability("os_version", "13");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Sauce Project-Maveric-ios");
		caps.setCapability("build", "Sauce iOS-Maveric-ios");
		caps.setCapability("name", "first_test-Maveric-ios");

		IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"),
				caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//System.out.println(driver.getPageSource());
		
		//enter username - standard-user
		driver.findElement(MobileBy.name("test-Username")).sendKeys("standard_user");
		
		//enter password - secret_sauce
		driver.findElement(MobileBy.xpath("//XCUIElementTypeSecureTextField[@name='test-Password']")).sendKeys("secret_sauce");
		
		//click on login
		driver.findElement(MobileBy.iOSNsPredicateString("label == 'LOGIN' AND name == 'test-LOGIN'")).click();
		
		// add the cart
		//*[@name='test-ADD TO CART' and @label='ADD TO CART']
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		
		
		driver.findElement(MobileBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();
		
		//scroll and click on checkout 
		//*[@name='test-CHECKOUT']
		
		
		driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down","predicateString", "name == 'test-CHECKOUT'"));
		
		
		driver.findElement(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).click();
		driver.quit();

	}

}
