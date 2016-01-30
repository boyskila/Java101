package wednesday.codetester.api;

import java.util.Arrays;

import wednesday.codetester.api.TestResultStorage.ResultPair;

public class TestMethods {
	// Put results in the List as expected and exact resultPairs

	// name of the current method
	private static String name;

	/*
	 * @Param 'a' expected result
	 * 
	 * @Param 'b' tested method return value
	 */
	public static void assertEquals(int a, int b) throws Exception {
		name = Thread.currentThread().getStackTrace()[2].getMethodName();
		TestResultStorage.resultMap.add(new ResultPair<Integer>(a, b, a == b,
				name));
	}

	public static void assertEquals(double a, double b) throws Exception {
		name = Thread.currentThread().getStackTrace()[2].getMethodName();
		TestResultStorage.resultMap.add(new ResultPair<Double>(a, b, a == b,
				name));
	}

	public static void assertEquals(Integer[] a, Integer[] b) throws Exception {
		name = Thread.currentThread().getStackTrace()[2].getMethodName();
		TestResultStorage.resultMap.add(new ResultPair<Integer[]>(a, b, Arrays
				.equals(a, b), name));
	}

	public static void assertTrue(Boolean b) {
		name = Thread.currentThread().getStackTrace()[2].getMethodName();
		TestResultStorage.resultMap.add(new ResultPair<Boolean>(b
				.booleanValue(), name));
	}
}
