package src.Main;
import java.util.Scanner;

import org.json.simple.JSONObject;



public class UI {

	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Asks user if they want to see stock graph and calls graph method
	 * @param j JSON Object
	 * @param name of stock ticker
	 */
	public static void graphPrompt(org.json.simple.JSONObject j, String name) {
		System.out.println("Would you like to export this data as a graph?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int input = Integer.parseInt(takeUserInput());
		if (input == 1) {
			Grapher.parseData(j, name);
		}
		else if (input == 2) {
			return;
		}
		else {
			System.out.println("Invalid option. Please enter 1 or 2");
			graphPrompt(j, name);
		}
		return;
		
	}
	
	public static boolean proceedToOptions(String name) {
		System.out.println("Proceed to request data for " + name+"?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int input = Integer.parseInt(takeUserInput());
		if (input == 1) {
			return true;
		}
		else if (input == 2) {
			return false;
		}
		else {
			System.out.println("Invalid option. Please enter 1 or 2");
			proceedToOptions(name);
		}
		return false;
	}

	/**
	 * Prompts user for stock symbol and reads input
	 * @return input if empty
	 */
	public static String getStockSymbol() {
		System.out.println("Please enter a stock symbol:");
		
		return takeUserInput();
	}
	
	public static String takeUserInput() {

		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
				
			}
		}
	}
	
	public static void printOptionsMenu() {
		System.out.println("Please select an option from the list:");
		
		System.out.println("1. Price");
		System.out.println("2. Daily Change");
		System.out.println("3. Yearly Price Information");
		System.out.println("4. Company Info");
		System.out.println("5. Calculate Profit/Loss");
		System.out.println("6. Request info for another stock");
		
	}
	
	/**
	 * Prompts user for stock data option, reads input, and sets the parse option
	 * @return the Parse option
	 */
	public static ParseOptions getOption() {
		while(true) {
		printOptionsMenu();
		
		String input=takeUserInput();
		
		int c = Integer.parseInt(input);
		switch (c) {
			case 1:
				return ParseOptions.price;
			case 2:
				return ParseOptions.change;
			case 3:
				return ParseOptions.yearlyPrice;
			case 4:
				return ParseOptions.companyInfo;
			case 5:
				return ParseOptions.profitLoss;
			case 6:
				return ParseOptions.newRequest;
			
			default:
				input = null;
				getOption();
		}
		
	}
	}
	
	/**
	 * Prompts user with options after displaying selected info
	 * @return true if they want to return to menu and false if they want to exit
	 */
	public static boolean getNextCommand() {
		System.out.println("Press 1 to return to option menu");
		System.out.println("Press 2 to exit");
		while (true) {
		
		String input=takeUserInput();
		
		int c = Integer.parseInt(input);
		if (c == 1) {
			return true;
		}
		else if(c == 2){
			return false;
		}
		else {
			continue;
		}
		
		}
	}
	
}