package Main;
import org.json.simple.JSONObject;

public class Main {

	
	
	
	public static void main(String[] args) {
		while (true) {
			
			JSONObject json = start();
			while (true) {
				ParseOptions option = UI.getOption();
				if (option == ParseOptions.newRequest) {
					break;
				}
				else {
					Parser.handleOption(json,option);
					//option = 
					//TODO: fix outputa
				}
			}
		}
	}
	
	
	
	
	
	public static JSONObject start() {
		
		
		String input = UI.getStockSymbol();
		
		
		String dataString = API.requestData(input, null);
		
		JSONObject json = Parser.convertToJson(dataString);
		Parser.displayBasicInfo(json);
		
		return json;
		
	}
	
}
