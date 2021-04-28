package  src.Main;
import org.json.simple.JSONObject;

public class Main {
	public static String currentSymbol = "";
	
	public static void main(String[] args) {
		
		while (true) {
			
			start();
			while (true) {
				ParseOptions option = UI.getOption();
				if (option == ParseOptions.newRequest) {
					break;
				}
				else {
					Parser.handleOption(currentSymbol,option);
					if (!UI.getNextCommand()) {
						return;
					}
				}
			}
		}
	}
	


	public static String start() {
		
		ReqOptions reqType = ReqOptions.companyInfo;
		String symbol = UI.getStockSymbol();
		
		String dataString = API.requestData(symbol, reqType);
		
		JSONObject json = Parser.convertToJson(dataString);
		String name = (String) json.get("name");
		if (UI.proceedToOptions(name)) {
			currentSymbol = (String) json.get("ticker");
			return name;
		}
		else {
			start();
		}
		return "";
		
		
		
	}
	
}
