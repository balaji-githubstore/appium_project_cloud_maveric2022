package com.maveric.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
//cloud device
public class Demo4SignUp {

	public static void main(String[] args) throws MalformedURLException {
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
		
		driver.findElement(MobileBy.xpath("//*[@content-desc='Settings']")).click();
		
		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();
		
		
		driver.findElement(MobileBy.xpath("//*[@text='Sign up with email']")).click();
		
		driver.findElement(MobileBy.xpath("//*[@text='First name']")).sendKeys("bala");
		driver.findElement(MobileBy.xpath("//*[@text='Last name']")).sendKeys("dina");
		
		//email address
		//password 
		//click on create
		
		
		driver.quit();
		
		
	}

}
















