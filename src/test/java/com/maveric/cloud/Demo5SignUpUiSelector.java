package com.maveric.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

//cloud device
public class Demo5SignUpUiSelector {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		// Set your access credentials
		caps.setCapability("browserstack.user", "puttaveerasivara_zmURP1");
		caps.setCapability("browserstack.key", "THU4zUrBEBptxqAJkENt");

		// Set URL of the application under test
		 caps.setCapability("app", "bs://c084e2a657a3b8e891599d8977edebf05ac44057");

		// Specify device and os_version for testing
		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");
		caps.setCapability("project", "First Java Project");
		caps.setCapability("build", "browserstack-build-1");
		caps.setCapability("name", "first_test");

		// Initialise the remote Webdriver using BrowserStack remote URL
		// and desired capabilities defined above
		AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();

		driver.findElement(MobileBy.AccessibilityId("Settings")).click();

		// find using resource-id
		// driver.findElement(AppiumBy.id("")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().textContains(\"address\")")).sendKeys("bala");
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().descriptionContains(\"Pass\")"))
				.sendKeys("hello123");

		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\").index(0)")).click();
		driver.quit();

	}

}
