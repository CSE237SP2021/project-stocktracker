package Main;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class API {
	
	//API KEY: a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7
	
//	public static void main(String[] args) {
//		System.out.println("Please enter a stock symbol:");
//		Scanner scanner = new Scanner(System.in);
//		String input;
//		while (true) {
//			input = scanner.nextLine();
//			if (!input.isEmpty()) {
//				break;
//			}
//		}
//		
//		
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://investors-exchange-iex-trading.p.rapidapi.com/stock/"+input+"/book"))
//				.header("x-rapidapi-key", "a0e7aae970mshba06b82dc4aff3cp1667cdjsn66a8fb194136")
//				.header("x-rapidapi-host", "investors-exchange-iex-trading.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		try {
//		
//
//		
//			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//			String s = response.body().toString();
//			//System.out.print(s);
//			JSONParser parser = new JSONParser();
//		
//			try {
//				Object ob;
//				ob =  parser.parse(s);
//				JSONObject json = (JSONObject) ob;
//				JSONObject j = (JSONObject) json.get("uote");
//				Date d = new Date((long)j.get("latestUpdate"));
//				System.out.println("Displaying data for " + j.get("companyName") + ", as of " + d);
//				System.out.println("Latest Price: $" + j.get("latestPrice"));
//				System.out.println("High: $" + j.get("high"));
//				System.out.println("Low: $" + j.get("low"));
//			} catch (ParseException e) {
//			// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
//
//	
//	}
//	
	
	public static String requestData(String symbol, String reqType) {
		
		
		// Handling different request types in the future, defaults to "book" when passed null
		reqType = reqType != null ? reqType : "book";
		
		
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://investors-exchange-iex-trading.p.rapidapi.com/stock/"+symbol+"/"+reqType))
				.header("x-rapidapi-key", "a0e7aae970mshba06b82dc4aff3cp1667cdjsn66a8fb194136")
				.header("x-rapidapi-host", "investors-exchange-iex-trading.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		try {
		

		
			HttpResponse<String> response = HttpClient.newHttpClient().send(req, HttpResponse.BodyHandlers.ofString());
			 return response.body().toString();
		
		
		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
