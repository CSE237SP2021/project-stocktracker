package Main;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

	static JSONParser parser = new JSONParser();
	
	
	
	public static JSONObject convertToJson(String s) {
		
		try {
			JSONObject json = (JSONObject) parser.parse(s);
			
			return json;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("convertToJson()");
		}
		
		return null;
	}
	
	public static void displayBasicInfo(JSONObject json) {
		// TODO: have to do something here if req not of type "book" (request and save all types or something)
		try {
		JSONObject j = (JSONObject) json.get("quote");
		Date d = new Date((long)j.get("latestUpdate"));
		System.out.println("Displaying data for " + j.get("companyName") + ", as of " + d);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void handleOption(JSONObject json, ParseOptions option) {
		JSONObject j = (JSONObject) json.get("quote");
		
		switch (option) {
		
		
			case price:
				System.out.println("Latest Price: $" + j.get("latestPrice"));
				System.out.println("High: $" + j.get("high"));
				System.out.println("Low: $" + j.get("low"));
				break;
			case change:
				System.out.println("Open Price: $" + j.get("open"));
				System.out.println("Close Price: $" + j.get("close"));
				System.out.println("Change: $" + j.get("change"));
				System.out.println("Change Percentage: " + j.get("changePercent"));
				break;
			case yearlyPrice:
				System.out.println("Latest Price: $" + j.get("latestPrice"));
				System.out.println("Highest Yearly Price: $" + j.get("week52High"));
				System.out.println("Lowest Yearly Price: $" + j.get("week52Low"));
				break;
			default:
				
			
		}
		
		
		
	}
	
	
	
}
