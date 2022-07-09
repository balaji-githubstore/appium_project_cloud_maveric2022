package com.maveric.ioscloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class Demo1NativeApp {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		// Set URL of the application under test
		caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

		// Specify device and os_version for testing
		caps.setCapability("device", "iPhone 11 Pro");
		caps.setCapability("os_version", "13");

		// Set other BrowserStack capabilities
		caps.setCapability("project", "First Java Project-Maveric-ios");
		caps.setCapability("build", "Java iOS-Maveric-ios");
		caps.setCapability("name", "first_test-Maveric-ios");

		IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://hub-cloud.browserstack.com/wd/hub"),
				caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println(driver.getPageSource());
		
		
		driver.quit();

	}

}
