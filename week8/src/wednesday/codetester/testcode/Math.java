package wednesday.codetester.testcode;

public class Math {
	public int sum(int a, int b) {
		return a + b;
	}

	public double devide(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("Can't devide by zero");
		}
		return a / b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int pow(int a, int b) {
		for (int i = 1; i < b; i++) {
			a <<= 1;
		}
		return a;
	}

	public boolean isPI(double number) {
		return 3.14 == number;
	}
}
