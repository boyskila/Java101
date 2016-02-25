package wednesday.statistic;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		//13, 18, 13, 14, 13, 16, 14, 21, 13
		Statistic storage = new Statistic();
		System.out
				.println("Add numbers and find there \"MEAN\", \"MEDIAN\", \"MODE\" and \"RANGE\"\n");
		System.out.println("For exit press Q");
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				storage.add(Integer.parseInt(sc.nextLine()));
			} catch (Exception e) {
				break;
			}
		}
		System.out.print("Entered numbers are: ");
		for (int i : storage) {
			System.out.print(i + " ");
		}
		// Average
		System.out.println("\n  \"MEAN\" is: " + storage.getMean());
		// middle number in the list
		System.out.println("  \"MEDIAN\" is: " + storage.getMedian());
		// most repeated number
		System.out.println("  \"MODE\" is: " + storage.getMode());
		// Range between smallest and largest number
		System.out.println("  \"RANGE\" is: " + storage.getRange());
		sc.close();
	}

}
