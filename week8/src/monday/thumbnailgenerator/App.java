package monday.thumbnailgenerator;

import java.io.File;
import java.io.IOException;

public class App {
	static final File PATH = new File("/home/boyko/Desktop/dir");

	public static void main(String[] args) throws InterruptedException, IOException {
		int a = (int) 2E5;
		System.out.println(a);
//		Map<BufferedImage, File> map = new Hashtable<>();
//		RecursiveWalk walk = new RecursiveWalk(map, PATH);
//		FileWriterThread fr = new FileWriterThread(map);
//		walk.start();
//		fr.start();
//		walk.join();
//		fr.join();
//		System.out.println("Operation Done!");
	}
}
