package src.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.Main.Parser;

class ProfitLossTest {

	@Test
	void calculateProfitLossTest1() {
		
		double change= Parser.calculateProfitLoss(10, 10, 9);
		assertTrue(10.0 == change);
	}
	
	@Test
	void calculateProfitLossTest2() {
		
		double change= Parser.calculateProfitLoss(130.2, 10, 140.5);
		assertTrue(-103.0 == change);
	}
	
	@Test
	void calculateProfitLossTest3() {
		
		double change= Parser.calculateProfitLoss(231.2, 7, 205.7);
		assertTrue(178.5 == change);
	}


}
