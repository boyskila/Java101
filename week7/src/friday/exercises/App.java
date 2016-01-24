package friday.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		try {
			new Thread(new Devisor(10, 5));
		} catch (ArithmeticException e) {
			e = new ArithmeticException("Cant devide by zero");
		}
		List<Integer> numbers = new ArrayList<>();
		Random rand = new Random();
		for (int i = 1_000_000_0; i > 0; i--) {
			numbers.add(i);
		}
		long start = System.currentTimeMillis();
		Arrays.parallelSort(numbers.toArray(new Integer[numbers.size()]));
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
