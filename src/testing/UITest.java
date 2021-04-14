package src.testing;
import src.Main.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class UITest {

	
	@Test
	void test_getStockSymbol() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    UI.getStockSymbol(); 
	    String expectedOutput  = "Please enter a stock symbol:";
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void test_getOptionPrice() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.price);
	    System.setIn(sysInBackup);
		
	}
	
	@Test
	void test_getOptionChange() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.change);
	    System.setIn(sysInBackup);
		
	}

	@Test
	void test_getOptionYearlyPrice() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.yearlyPrice);
		System.setIn(sysInBackup);
		
	}
	
	@Test
	void test_getOptionNewRequest() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.newRequest);
	    System.setIn(sysInBackup);
		
	}
	
	@Test
	void test_getNextCommand() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    UI.getNextCommand(); 
	    String expectedOutput  = "Press 1 to return to option menu\nPress 2 to exit";
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	
}
