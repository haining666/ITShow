package com.hpe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hpe.util.JDBC;

public class TendencyDao {

	public String mkData() {
		JDBC jdbc = new JDBC();
		Map<String,String> myMap = new HashMap<String, String>();
		myMap.put("java", "172548");
		myMap.put("php", "182548");
		myMap.put(".net", "192548");
		/*ArrayList<Integer> myList = new ArrayList<Integer>();
		myList = jdbc.query("java");*/
		String myData = myMap.toString();
		return myData;
	}

}
