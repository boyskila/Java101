package monday.thumbnailcreator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	private static BlockingQueue<Image> paths = new LinkedBlockingQueue<>();

	// /home/boyko/Desktop/dir
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String[] arguments = sc.nextLine().split(" ");
		CommandLineArguments commandLineArgs = new CommandLineArguments(
				arguments);
		String filePath = commandLineArgs.getPath();
		int thumbnailWidth = commandLineArgs.getWidth();
		int thumbnailHeight = commandLineArgs.getHeight();
		boolean recursiveOption = commandLineArgs.isRecursiveOption();
		new FileReader(paths,filePath,recursiveOption).read();;
		Thread t1 = new Thread(new ImageWriterThread(paths), "Writer");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(paths);
	}
}
