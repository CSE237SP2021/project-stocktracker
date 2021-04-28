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
	
}
