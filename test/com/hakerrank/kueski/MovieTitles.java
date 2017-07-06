package com.hakerrank.kueski;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;

public class MovieTitles {
	static String[] getMovieTitles(String substr) {
		String service = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
		String finalUrl = service.concat(substr);
		List<String> titles = new ArrayList<String>();
		StringBuilder result = new StringBuilder();
		URL url;
		HttpURLConnection conn;
		try {
			System.out.println("URL = " + finalUrl);
			url = new URL(finalUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println("result: \n" + result);
			
			JSONParser parser = new JSONParser();
			Object obj;
			obj = parser.parse(result.toString());
			
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println(jsonObject);
			
			JSONArray data = (JSONArray) jsonObject.get("data");
			System.out.println("data: " + data + "\n");
			for (Object record : data) {
				Object title = ((JSONObject) record).get("Title");
				System.out.println("Title: " + title);
				titles.add((String) title);
			}
			System.out.println(titles);
			return titles.toArray(new String[titles.size()]);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}
}
