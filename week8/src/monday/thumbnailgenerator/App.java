package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.io.File;

public class App {
	static final File PATH = new File("/home/boyko/Desktop/dir");

	public static void main(String[] args) {
		// int height = Integer.parseInt(args[0]);
		// int width = Integer.parseInt(args[1]);
		int height = 150;
		int width = 150;
		BlockingQueue<BufferedImage> images = new BlockingQueue<>();
		ThumbnailGenerator thumbnailGenerator = new ThumbnailGenerator(images, PATH, height, width);
		FileReaderThread fileReader = new FileReaderThread(PATH, images);
		FileWriterThread fileWriter = new FileWriterThread(thumbnailGenerator);

		fileReader.start();
		fileWriter.start();
		try {
			fileReader.join();
			if (images.isEmpty()) {
				thumbnailGenerator.setQuit(false);
			}
			fileWriter.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
		}
		System.out.println("Operation Done!");
	}
}
