//API KEY: a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7

// HttpRequest request = HttpRequest.newBuilder()
// 		.uri(URI.create("https://investors-exchange-iex-trading.p.rapidapi.com/stock/crm/time-series"))
// 		.header("x-rapidapi-key", "a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7")
// 		.header("x-rapidapi-host", "investors-exchange-iex-trading.p.rapidapi.com")
// 		.method("GET", HttpRequest.BodyPublishers.noBody())
// 		.build();
// HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
// System.out.println(response.body());



//responded with "you are not subscribed to this api"
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class api {
	
	

	public static void main(String[] args) {
	
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://investors-exchange-iex-trading.p.rapidapi.com/stock/crm/time-series"))
			.header("x-rapidapi-key", "a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7")
			.header("x-rapidapi-host", "investors-exchange-iex-trading.p.rapidapi.com")
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	try {
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	}
	
	
}
