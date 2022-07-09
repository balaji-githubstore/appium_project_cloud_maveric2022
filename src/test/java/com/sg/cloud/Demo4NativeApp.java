package com.sg.cloud;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;

public class Demo4NativeApp {

	public static void main(String[] args) throws MalformedURLException {

		 DesiredCapabilities caps = new DesiredCapabilities();


         caps.setCapability("browserstack.user", "ashikrahaman_lTiypu");
         caps.setCapability("browserstack.key", "xa4x9xShtM9sLdLNcSxx");

         
         caps.setCapability("app", "bs://b2561537bfb95e97cc3b0ba1d28c3bf630f17fea");


         caps.setCapability("device", "iPhone 11 Pro");
         caps.setCapability("os_version", "13");

         caps.setCapability("project", "First Java Project-Maveric-ios");
         caps.setCapability("build", "Java ios-Maveric-ios");
         caps.setCapability("name", "First_test-Maveric-ios");


         IOSDriver<WebElement> driver = new IOSDriver<WebElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
         
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
       
         String PageSource=driver.getPageSource();
         System.out.println(PageSource);
         
         driver.quit();

	}

}
