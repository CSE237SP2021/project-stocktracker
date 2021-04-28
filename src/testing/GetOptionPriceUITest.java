package src.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import src.Main.ParseOptions;
import src.Main.UI;

public class GetOptionPriceUITest {

	@Test
	void test_getOptionPrice() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.price);
	    System.setIn(sysInBackup);
		
	}
}
