package com.RestAssured.practice;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Chapter1 {
//	@Test
//	public void requestToken() {
//		
//		Map<String, String> headers = new HashMap();
//		headers.put("x-api-key", "JpH0WmS7RMala2SDFJMvF70Z5EWqd8Cv88Md0RKj");
//		String requestBody = "{\"role\": \"\",\"schoolId\": 1020,\"identityId\": 8815703}";
//			
//		given().contentType(ContentType.JSON).headers(headers).body(requestBody).
//		when().		
//			post("https://wac5epldj9.execute-api.us-east-1.amazonaws.com/qa/ols/v1/jwt-session").
//		then().
//			log().body();
//	}
	
	@Test 
	public void collectionsAndSort() {
		ArrayList actualNames = new ArrayList(Arrays.asList("Johnson","Wilson","Ronan","Arnold"));
		Collections.sort(actualNames);
		System.out.println(actualNames);
		Assert.assertEquals(new ArrayList <> (Arrays.asList("Arnold","Johnson","Ronan","Wilson")),actualNames);
	}
	
	@Test
	public void collectionMethods() {
		Set fruit = new HashSet();
		fruit.add("apple");
		fruit.add("lemon");
		fruit.add("banana");
		System.out.println(fruit.size());
		System.out.println(fruit);
	}

}
