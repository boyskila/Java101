package monday.thumbnailcreator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		Scanner sc = new Scanner(System.in);
		String[] arguments = sc.nextLine().split(" ");
		// to receiving arguments from terminal just pass main method args
		CommandLineArguments commandLineArgs = new CommandLineArguments(
				arguments);
		String filePath = commandLineArgs.getPath();
		int thumbnailWidth = commandLineArgs.getWidth();
		int thumbnailHeight = commandLineArgs.getHeight();
		boolean recursiveOption = commandLineArgs.isRecursiveOption();
		long start = System.currentTimeMillis();
		new ThumbnailCreator(thumbnailWidth, thumbnailHeight, recursiveOption)
				.createThumbnails(filePath);
		System.out.println(System.currentTimeMillis() - start);
		sc.close();
	}
}
