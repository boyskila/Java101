package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;

import javax.imageio.ImageIO;

public class FileReaderThread extends Thread {
	private File file;
	private BlockingQueue<BufferedImage> queue;
	private static final FilenameFilter FILE_FILTER = new FileFilter();

	public FileReaderThread(File file, BlockingQueue<BufferedImage> queue) {
		this.file = file;
		this.queue = queue;
	}

	@Override
	public void run() {
		collectImages();
	}

	private void collectImages() {
		if (file.isDirectory()) {
			for (File f : file.listFiles(FILE_FILTER)) {
				try {
					queue.addLast(ImageIO.read(f));
				} catch (Exception e) {
				}
			}
		}
	}
}
