package src.testing;
import src.Main.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({  GetOptionChangeUITest.class, GetOptionCompanyInfoUITest.class, GetOptionNewRequest.class, GetOptionPriceUITest.class, GetOptionYearlyPriceUITest.class })

public  class UITest {

	/*
	@Test
	void test_getStockSymbol() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    UI.getStockSymbol(); 
	    String expectedOutput  = "Please select an option from the list:";
	    assertEquals(expectedOutput, outContent.toString());
	} */
	/*
	@Test
	void test_getNextCommand() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    UI.getNextCommand(); 
	    String expectedOutput  = "Press 1 to return to option menu\nPress 2 to exit";
	    assertEquals(expectedOutput, outContent.toString());
	}
	*/
	
}
