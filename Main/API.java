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

