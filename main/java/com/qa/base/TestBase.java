package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	
	public static void main(String[] args) {
		initialization();
	}
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		 System.setProperty("webdriver.chrome.driver","C:/Users/BNB/Downloads/chromeDriver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://openweathermap.org/city/2643743");
	}
}
