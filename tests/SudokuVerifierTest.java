import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
SudokuVerifier v = new SudokuVerifier();




	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		assertEquals("The digits can appear only once in the subgrid", v.verify("999999999999999999999999999999999999999999999999999999999999999999999999999999999"), -2);
		assertEquals("The digits can appear only once in one row", v.verify("418369825632158947957724316825437169791586432346912758289643571573291684164875293"), -3);
		assertEquals("The digits can appear only once in one column", v.verify("147369825632158947958724316825437169791586432346912758289643571573291684164875293"), -4);
		
	}
	
	@Test
	public void testShortString() {
		int a = v.verify(c.substring(1));
		assertEquals("Input string is too short", a, -1);
	}
	
	@Test
	public void testLongString() {
		int a = v.verify(c + "1");
		assertEquals("Input string is too long", a, -1);
	}
	
	@Test
	public void testNaughtyStrings() {
		assertEquals("Input string contains wrong type of characters", v.verify("41736632158947958724316825437169791586432346912758289643571573291684164875293"), 1); //contains hidden unicode
		assertEquals("Input string contains wrong type of characters", v.verify("417366null32158947958724316825437169791586432346912758289643571573291684164875293"), 1);
		assertEquals("Input string contains wrong type of characters", v.verify("-417369825632158947958724316825437169791586432346912758289643571573291684164875293"), -1);
	}
	
}
