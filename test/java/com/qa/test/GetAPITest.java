package com.qa.test;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.base.TestBase;
import com.qa.client.HomePage;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

import junit.framework.Assert;

public class GetAPITest extends TestBase{
	TestBase testBase;
	String serviceURL;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	CloseableHttpResponse closeableHttpResponsefile;
	HomePage homepage;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		testBase = new TestBase();
		serviceURL = prop.getProperty("ServiceURL");		
	}
	
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		closeableHttpResponse = restClient.get(serviceURL);
		//JSON stirng
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("response"+responseJson);
		String visibility = TestUtil.getValueByJPath(responseJson,"/main");
		//String humidity = TestUtil.getValueByJPath(responseJson,"/weather[0]/description");
		JSONObject mainObj=responseJson.getJSONObject("main");
		Object pr = mainObj.get("pressure");
		Object humid  = mainObj.get("humidity");
		Object prhpa = pr+" hpa";
		Object humidp = humid+" %";
	    //Date d1 = new Date();
		// unix = 1485762037;
		Date date = new Date(1485762037*1000);
		//System.out.println(date+"mm");
		//testBase.initialization();				
		String pressure = homepage.pressure(2643743);
		String humidity = homepage.humidity();
		System.out.println(humidity);
        //Assert.assertEquals(pressure, prhpa);
        Assert.assertEquals(humid, humidp);
	}
	
	

}
