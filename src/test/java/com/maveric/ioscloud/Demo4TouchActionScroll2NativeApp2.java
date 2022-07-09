package com.maveric.ioscloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Demo4TouchActionScroll2NativeApp2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

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

		// System.out.println(driver.getPageSource());

		// enter username - standard-user
		driver.findElement(MobileBy.name("test-Username")).sendKeys("standard_user");

		// enter password - secret_sauce
		driver.findElement(MobileBy.xpath("//XCUIElementTypeSecureTextField[@name='test-Password']"))
				.sendKeys("secret_sauce");

		// click on login
		driver.findElement(MobileBy.iOSNsPredicateString("label == 'LOGIN' AND name == 'test-LOGIN'")).click();

		// add the cart
		// *[@name='test-ADD TO CART' and @label='ADD TO CART']
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();
		driver.findElement(MobileBy.xpath("//*[@name='test-ADD TO CART']")).click();

		driver.findElement(MobileBy.xpath("//XCUIElementTypeOther[@name='test-Cart']")).click();

		Thread.sleep(5000);

		// presence
		int size = driver.findElements(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).size();
		System.out.println(size);

		// visibilty
		boolean visible = driver.findElement(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed();
		System.out.println(visible);

		TouchAction action = new TouchAction(driver);

		//based of visibility - doing the scroll
		while (driver.findElement(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed() == false) 
		{
			action.press(PointOption.point(364, 503)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
					.moveTo(PointOption.point(363, 414)).release().perform();
		}
		
		driver.findElement(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).click();

		driver.quit();
		
		
//		while (driver.findElements(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).size()==1 && 
//				driver.findElement(MobileBy.iOSNsPredicateString("name == 'test-CHECKOUT'")).isDisplayed() == false) 
//		{
//			action.press(PointOption.point(364, 503)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
//					.moveTo(PointOption.point(363, 414)).release().perform();
//		}
		

	}

}
