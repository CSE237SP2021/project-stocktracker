package src.Main;
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
	
	public static String requestData(String symbol, ReqOptions reqType) {
		
		
		// Handling different request types in the future, defaults to "book" when passed null
		String url = setURL(symbol, reqType);
		
		
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create(url))
				
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
	
	public static String setURL(String symbol, ReqOptions reqType) {
		ReqOptions o = reqType;
		
		switch (o) {
			case quote:
				return "https://finnhub.io/api/v1/quote?symbol="+ symbol +"&token=c1ebmhn48v6t1299jb6g";
			case historical:
				Long time =  System.currentTimeMillis()/1000L;
				
				Long time2 = time-(3153600000L/1000L);
				return "https://finnhub.io/api/v1/stock/candle?symbol="+symbol+"&resolution=1&from="+time2+"&to="+time+"&token=c1ebmhn48v6t1299jb6g";
			case companyInfo:
				return "https://finnhub.io/api/v1/stock/profile2?symbol="+symbol+"&token=c1ebmhn48v6t1299jb6g";
			default:
				return "";
		}
		
	}
}

