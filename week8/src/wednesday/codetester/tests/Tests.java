package wednesday.codetester.tests;

import wednesday.codetester.annotations.*;
import wednesday.codetester.testcode.Math;
import static wednesday.codetester.api.TestMethods.*;

public class Tests {
	private Math mathOperations;

	@Before
	public void init() {
		mathOperations = new Math();
	}

	@CodeTester
	public void testDevide() throws Exception {
		assertEquals(4, mathOperations.devide(8, 2));
	}

	@CodeTester
	public void testPow() throws Exception {
		assertEquals(1024, mathOperations.pow(2, 10));
		
	}

	@CodeTester
	public void testSum() throws Exception {
		assertTrue(mathOperations.isPI(3.14));
	}

	@CodeTester
	public void testMultiply() throws Exception {
		assertEquals(25, mathOperations.multiply(6, 5));
	}
}
