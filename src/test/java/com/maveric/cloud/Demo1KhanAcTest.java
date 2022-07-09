package com.maveric.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Demo1KhanAcTest {

	public static void main(String[] args) throws MalformedURLException {

		// write the code and send it to browserstack appium server url
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserstack.user", "dinakaranbalaji1");
		caps.setCapability("browserstack.key", "6yXRE4nK1fyvTHWA2kPD");

		caps.setCapability("app", "bs://0c23b94e038d3a0dd02162933b6b6900fdb1835d");

		caps.setCapability("device", "Google Pixel 3");
		caps.setCapability("os_version", "9.0");

		caps.setCapability("project", "First Java Project-Maveric");
		caps.setCapability("build", "Java Android-Maveric");
		caps.setCapability("name", "khan-academy-sign in-test");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Dismiss']")).click();
		//driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		
		String source=driver.getPageSource();
		System.out.println(source);
		
		driver.quit();  //if not ran then timeout will happen after 60 sec and then report will be shown

	}

}
