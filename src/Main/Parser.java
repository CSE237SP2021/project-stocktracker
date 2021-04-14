package Main;
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

	static JSONParser parser = new JSONParser();
	
	
	/**
	 * Converts string returned from API call to a JSON object
	 * @param s the string of stock data returned from the API call
	 * @return a JSON object containing the stock data
	 */
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
	
	/**
	 * Displays stock company name and current date and time
	 * @param json the object returned from convertToJson function that contains stock info
	 */
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
	/**
	 * Displays specific stock info based on user input
	 * @param json the object returned from convertToJson function that contains stock info
	 * @param option stock data option selected by the user
	 */
	
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
				System.out.printf("Change: $%.2f %n", ((double)j.get("close")-(double)j.get("open")));
				System.out.printf("Change Percentage: %.2f %n", 100*(((double)j.get("close")-(double)j.get("open"))/(double)j.get("close")));
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
