package week12;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.stream().map((x) -> x*x).forEach(System.out::println);
	}
}
