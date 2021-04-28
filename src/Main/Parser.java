package src.Main;
import java.util.Date;
import java.util.Scanner;
import java.lang.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONArray.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {

	public static Scanner scanner = new Scanner(System.in);
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
	

	public static void handleOption(String name, ParseOptions option) {
		JSONObject j = null;
		
		switch (option) {
		
		
			case price:
	
				
				j = convertToJson(API.requestData(name, ReqOptions.quote));
				
				System.out.println("Current Price: $" + j.get("c"));
				System.out.println("Daily High: $" + j.get("h"));
				System.out.println("Daily Low: $" + j.get("l"));
				
				break;
			case change:
				j = convertToJson(API.requestData(name, ReqOptions.quote));
				System.out.println("Open Price: $" + j.get("o"));
				System.out.println("Close Price: $" + j.get("c"));
				System.out.printf("Change: $%.2f %n", ((double)j.get("c")-(double)j.get("o")));
				System.out.printf("Change Percentage: %.2f %n", 100*(((double)j.get("c")-(double)j.get("o"))/(double)j.get("c")));
				break;
			case yearlyPrice:
				j = convertToJson(API.requestData(name, ReqOptions.historical));
				JSONArray prices = (JSONArray) j.get("c");
				double[] minmax = findMinMax(prices);
				double current = ((double)prices.get(prices.size()-1));
				double first = ((double)prices.get(0));
				System.out.println("Latest Price: $" + prices.get(prices.size()-1));
				System.out.printf("Yearly Change: $%.2f %n", (current -  first));
				System.out.println("Highest Yearly Price: $" + minmax[1]);
				System.out.println("Lowest Yearly Price: $" + minmax[0]);
				UI.graphPrompt(j, name);
				break;
			case companyInfo:
				j = convertToJson(API.requestData(name, ReqOptions.companyInfo));
				System.out.println("Name: "+ j.get("name"));
				System.out.println("Industry: "+ j.get("finnhubIndustry"));
				System.out.println("Country: "+ j.get("country"));
				System.out.println("Exchange: "+ j.get("exchange"));
				System.out.println("Outstanding Shares: "+ j.get("shareOutstanding"));
				System.out.println("IPO (Initial Public Offering): "+ j.get("ipo"));
				break;
			case profitLoss:
						
				double profitOrLoss=calculateProfitLoss(name);
				if(profitOrLoss>=0) {
					System.out.printf("You made a profit of $%.2f %n", profitOrLoss);
				}
				else {
					System.out.printf("You lost $%.2f %n", profitOrLoss*-1);
				}
				
		default:
				
			
		}
		
	}
	
	public static int getShares() {
		System.out.println("Enter how many shares you own:");
		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				return Integer.parseInt(input);
				
			}
		}
	}
	

	public static double buyPrice() {
		System.out.println("Enter buy price:");
		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				return Double.parseDouble(input);
				
			}
		}
	}
	
	public static double calculateProfitLoss(String name) {
		JSONObject j = null;
		j = convertToJson(API.requestData(name, ReqOptions.quote));
		int shares=getShares();
		double buyPrice=buyPrice();
		double buyValue=shares*buyPrice;
		double currentPrice=(double)j.get("c");
		double currentValue=shares*currentPrice;
		double change=currentValue-buyValue;
		return change;
	}
	
	public static void displayCompanies(JSONObject json) {
		
		int count = (int) json.get("count");
		for (int i = 0; i < count; i++) {
			System.out.println("Company: " + json.get("description"));
			System.out.println("Symbol: " + json.get("displaySymbol"));
			System.out.println();
		}
		
	}
	
	
	static double[] findMinMax(JSONArray arr) {
		double min = 100000;
		double max=0;
		for (int i = 0; i < arr.size(); i++){
			
			try {
			double num = ((double) arr.get(i));
			}
			catch(ClassCastException e) {
				continue;
			}
			double num = ((double) arr.get(i));
			if (num>max) {
				max = num;
			}
			if (num<min) {
				min = num;
			}
		}
		double[] ret = {min,max};
		return ret;
	}

	
	
}
