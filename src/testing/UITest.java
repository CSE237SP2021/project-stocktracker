package src.testing;
import src.Main.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class UITest {

	@Test
	void test_getOption() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.price);
		
		
		in = new ByteArrayInputStream("10 \n 1".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.price);
		System.setIn(sysInBackup);
		
	}
	


}
