package com.maveric.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Demo3Check {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials

		caps.setCapability("browserstack.user", "");
		caps.setCapability("browserstack.key", "");

		caps.setCapability("app", "bs://f02586e04caaa2ba80cce55ad619b01ce4db53e8");

		// Set URL of the application under test
//		caps.setCapability("app", "bs://a29fac267153957e40b5ab305d562eea74a780fd");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities`

		caps.setCapability("project", "First Java Project-Maveric 3");
		caps.setCapability("build", "Java Android-Maveric 3");
		caps.setCapability("name", "khan-academy-sign in-test-3");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"),
				caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();

		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();

		driver.findElement(MobileBy.xpath("//*[@text='Enter an e-mail address or username']")).sendKeys("bala");
		driver.findElement(MobileBy.xpath("//*[@content-desc='Password']")).sendKeys("welcome123");

		driver.findElement(MobileBy.xpath("(//*[@text='Sign in'])[2]")).click();

		String actualError = driver.findElement(MobileBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);

		driver.quit(); // shoud run always other timeout error will be shown

		// Invoke driver.quit() after the test is done to indicate that the test is
		// completed.
//        driver.quit();
	}

}
//will start at 11:55