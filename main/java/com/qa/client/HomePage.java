package com.qa.client;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	public static WebDriver driver;
	public static TestBase testBase;
	
	
	public static String pressure(int cityId) {
		 System.setProperty("webdriver.chrome.driver","C:/Users/BNB/Downloads/chromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
	     driver.get("https://openweathermap.org/city/"+cityId);
		 String pressValue = driver.findElement(By.xpath("*//div[@id='weather-widget']/table/tbody/tr[3]/td[2]")).getText();
		 return pressValue;
	}
	
	public static String humidity() {
		 String humidValue = driver.findElement(By.xpath("*//div[@id='weather-widget']/table/tbody/tr[4]/td[2]")).getText();
		 return humidValue;
	}

}
