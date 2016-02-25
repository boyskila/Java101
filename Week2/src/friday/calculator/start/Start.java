package friday.calculator.start;

import java.util.Scanner;

import friday.calculator.parser.Calculator;

public class Start {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter expression:> ");
			String expression = sc.nextLine();
			if (expression.equals("exit")) {
				System.out.println("bye!");
				sc.close();
				return;
			} else {
				System.out.printf("Output:> %s\n", new Calculator(expression).start());
			}
		}
	}
}
