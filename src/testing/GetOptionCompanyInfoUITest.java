package src.testing;

import static org.junit.jupiter.api.Assertions.*;
import src.Main.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

public class GetOptionCompanyInfoUITest {
	@Test
	void test_getOptionCompanyInfo() {
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
		System.setIn(in);
		assertTrue(UI.getOption() == ParseOptions.companyInfo);
	    System.setIn(sysInBackup);
		
	}

}
