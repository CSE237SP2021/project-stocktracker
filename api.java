//API KEY: a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7

HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://investors-exchange-iex-trading.p.rapidapi.com/stock/crm/time-series"))
		.header("x-rapidapi-key", "a9214123c3msh9cece16cbc5921fp1cd93ejsnd52156789df7")
		.header("x-rapidapi-host", "investors-exchange-iex-trading.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
