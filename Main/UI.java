package Main;
import java.util.Scanner;

public class UI {

	public static Scanner scanner = new Scanner(System.in);

	
	public static String getStockSymbol() {
		System.out.println("Please enter a stock symbol:");
		
		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				return input;
				
			}
		}
	}
	
	
	public static ParseOptions getOption() {
		while(true) {
		System.out.println("Please select an option from the list:");
	
	
		System.out.println("1. Price");
		System.out.println("2. Daily Change");
		System.out.println("3. Yearly Price Information");
		System.out.println("4. Request info for another stock");
		

		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				break;
				
			}
		}
		int c = Integer.parseInt(input);
		switch (c) {
			case 1:
				return ParseOptions.price;
			case 2:
				return ParseOptions.change;
			case 3:
				return ParseOptions.yearlyPrice;
			case 4:
				return ParseOptions.newRequest;
			default:
				input = null;
				getOption();
		}
		
	}
	}
	
	public static boolean getNextCommand() {
		System.out.println("Press 1 to return to option menu");
		System.out.println("Press 2 to exit");
		while (true) {
		String input;
		while (true) {
			input = scanner.nextLine();
			if (!input.isEmpty()) {
				break;
				
			}
		}
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