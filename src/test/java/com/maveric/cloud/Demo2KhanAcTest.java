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

public class Demo2KhanAcTest {

	public static void main(String[] args) throws MalformedURLException {

		// write the code and send it to browserstack appium server url
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		caps.setCapability("app", "bs://0c23b94e038d3a0dd02162933b6b6900fdb1835d");

		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		caps.setCapability("project", "First Java Project-Maveric 3");
		caps.setCapability("build", "Java Android-Maveric 3");
		caps.setCapability("name", "khan-academy-sign in-test-3");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();
		
		driver.findElement(MobileBy.xpath("//*[@text='Enter an e-mail address or username']")).sendKeys("bala");
		driver.findElement(MobileBy.xpath("//*[@content-desc='Password']")).sendKeys("welcome123");
		
		driver.findElement(MobileBy.xpath("(//*[@text='Sign in'])[2]")).click();
		
		String actualError=driver.findElement(MobileBy.xpath("//*[contains(@text,'issue')]")).getText();
		System.out.println(actualError);	
		
		driver.quit(); // shoud run always other timeout error will be shown
	}

}
