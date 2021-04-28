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
	

	@Test
	void test_aaplDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Apple Inc"
				+ "\"Industry\":\"Technology\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NASDAQ NMS - GLOBAL MARKET\\n"
				+ "\"Outstanding Shares\":\"16788.096\"\\n"
				+ "\"IPO (Initial Public Offering)\":1980-12-12\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	
	
	@Test
	void test_msftDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Microsoft Corp"
				+ "\"Industry\":\"Technology\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NASDAQ NMS - GLOBAL MARKET\\n"
				+ "\"Outstanding Shares\":\"7542.215767\"\\n"
				+ "\"IPO (Initial Public Offering)\":1986-03-13\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_googlDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Alphabet Inc"
				+ "\"Industry\":\"Media\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NASDAQ NMS - GLOBAL MARKET\\n"
				+ "\"Outstanding Shares\":\"674.136665\"\\n"
				+ "\"IPO (Initial Public Offering)\":2004-08-19\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_ibmDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"International Business Machines Corp"
				+ "\"Industry\":\"Technology\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NEW YORK STOCK EXCHANGE, INC.\\n"
				+ "\"Outstanding Shares\":\"892.653424\"\\n"
				+ "\"IPO (Initial Public Offering)\":1915-11-11\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_excofDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Exco Technologies Ltd"
				+ "\"Industry\":\"Auto Components\"\\n"
				+ "\"Country\":\"CA\"\\n"
				+ "\"Exchange\":\"TORONTO STOCK EXCHANGE\\n"
				+ "\"Outstanding Shares\":\"39.270497\"\\n"
				+ "\"IPO (Initial Public Offering)\":1986-10-21\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_woofDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Petco Health and Wellness Company Inc"
				+ "\"Industry\":\"Retail\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NASDAQ NMS - GLOBAL MARKET\\n"
				+ "\"Outstanding Shares\":\"302.005702\"\\n"
				+ "\"IPO (Initial Public Offering)\":2021-01-14\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_upowDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"UAN Power Corp"
				+ "\"Industry\":\"N/A\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"OTC MARKETS\\n"
				+ "\"Outstanding Shares\":\"0\"\\n"
				+ "\"IPO (Initial Public Offering)\":2010-07-29\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_funDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Cedar Fair LP"
				+ "\"Industry\":\"Hotels, Restaurants & Leisure\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NEW YORK STOCK EXCHANGE, INC.\\n"
				+ "\"Outstanding Shares\":\"56.828237\"\\n"
				+ "\"IPO (Initial Public Offering)\":1987-04-23\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_gmeDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"GameStop Corp"
				+ "\"Industry\":\"Retail\"\\n"
				+ "\"Country\":\"US\"\\n"
				+ "\"Exchange\":\"NEW YORK STOCK EXCHANGE, INC.\\n"
				+ "\"Outstanding Shares\":\"70.03165\"\\n"
				+ "\"IPO (Initial Public Offering)\":2005-10-10\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
	@Test
	void test_gDisplayBasicInfo() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		JSONObject json = Parser.convertToJson("{\"quote\":{\"Name\" : \"Genpact Ltd"
				+ "\"Industry\":\"Technology\"\\n"
				+ "\"Country\":\"BM\"\\n"
				+ "\"Exchange\":\"NEW YORK STOCK EXCHANGE, INC.\\n"
				+ "\"Outstanding Shares\":\"187.149112\"\\n"
				+ "\"IPO (Initial Public Offering)\":2007-08-02\"}");
		Parser.displayBasicInfo(json);
		
		equals(outContent.toString());
	}
}
