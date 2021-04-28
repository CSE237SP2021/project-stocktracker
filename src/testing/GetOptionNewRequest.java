package src.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import src.Main.ParseOptions;
import src.Main.UI;

public class GetOptionNewRequest {

	@Test
	void test_getOptionNewRequest() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.newRequest);
	    System.setIn(sysInBackup);
		
	}

}
