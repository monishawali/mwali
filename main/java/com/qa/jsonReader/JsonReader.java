package com.qa.jsonReader;

import java.io.FileReader;
import java.util.Iterator;
import java.util.function.Consumer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
    
    public static Object JsonReadFile(){
    	Iterator<Object> itr=null;
        JSONParser parser = new JSONParser(); 
        try { 
            Object obj = parser.parse(new FileReader(                    
            		"C:/Users/BNB/eclipse-workspace/apiTest/src/test/java/com/apiTest/test/city.list.json"));
            System.out.println(obj);
            JSONObject jsonObject = (JSONObject) obj;
            Object id = jsonObject.get("id");
            Object name = jsonObject.get("name");
            Object country = jsonObject.get("country");
            JSONArray companyList = ((JSONArray)jsonObject.get("data"));
            companyList.forEach((Consumer) jsonObject.get("country"));
            //.out.println("Id: " + name);
            }
        catch (Exception e) {
            e.printStackTrace();
        }
        return itr;
    }
	
	
}
