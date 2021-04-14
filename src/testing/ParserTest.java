package src.testing;
import src.Main.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import src.Main.Parser;

class ParserTest {
//{"quote":{"symbol":"AAPL","companyName":"Apple Inc.","primaryExchange":"Nasdaq Global Select","sector":"Technology","calculationPrice":"close","open":126.5,"openTime":1617715802334,"close":227.01,"closeTime":1617739200337,"high":127.13,"low":120.64,"latestPrice":227.01,"latestSource":"Close","latestTime":"April 6, 2021","latestUpdate":1617739200337,"latestVolume":null,"iexRealtimePrice":null,"iexRealtimeSize":null,"iexLastUpdated":null,"delayedPrice":126.23,"delayedPriceTime":1617739199970,"extendedPrice":126.23,"extendedChange":-100.78,"extendedChangePercent":-0.44395,"extendedPriceTime":1617742800000,"previousClose":220.82,"change":null,"changePercent":null,"iexMarketPercent":null,"iexVolume":null,"avgTotalVolume":28048177,"iexBidPrice":null,"iexBidSize":null,"iexAskPrice":null,"iexAskSize":null,"marketCap":1025899051800,"peRatio":null,"week52High":228.22,"week52Low":120.64,"ytdChange":0.48276164267212823},"bids":[],"asks":[],"systemEvent":{}}
	
	// needs fixing
	@Test
	void test_displayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"symbol\":\"AAPL\",\"companyName\":\"Apple Inc.\",\"primaryExchange\":\"Nasdaq Global Select\",\"sector\":\"Technology\",\"calculationPrice\":\"close\",\"open\":126.5,\"openTime\":1617715802334,\"close\":227.01,\"closeTime\":1617739200337,\"high\":127.13,\"low\":120.64,\"latestPrice\":227.01,\"latestSource\":\"Close\",\"latestTime\":\"April 6, 2021\",\"latestUpdate\":1617739200337,\"latestVolume\":null,\"iexRealtimePrice\":null,\"iexRealtimeSize\":null,\"iexLastUpdated\":null,\"delayedPrice\":126.23,\"delayedPriceTime\":1617739199970,\"extendedPrice\":126.23,\"extendedChange\":-100.78,\"extendedChangePercent\":-0.44395,\"extendedPriceTime\":1617742800000,\"previousClose\":220.82,\"change\":null,\"changePercent\":null,\"iexMarketPercent\":null,\"iexVolume\":null,\"avgTotalVolume\":28048177,\"iexBidPrice\":null,\"iexBidSize\":null,\"iexAskPrice\":null,\"iexAskSize\":null,\"marketCap\":1025899051800,\"peRatio\":null,\"week52High\":228.22,\"week52Low\":120.64,\"ytdChange\":0.48276164267212823},\"bids\":[],\"asks\":[],\"systemEvent\":{}}\n");
		Parser.displayBasicInfo(json);
		
		assertEquals("Displaying data for Apple Inc., as of Tue Apr 06 15:00:00 CDT 2021", outContent.toString());
	}

}
