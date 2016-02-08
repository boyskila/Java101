package monday.thumbnailcreator;

import java.io.File;

public class ThumbnailCreator {
	@SuppressWarnings("unchecked")
	private static ImageStorage<Image> storage = (ImageStorage<Image>) ImageStorage
			.getInstance();
	private int thumbnailWidth;
	private int thumbnailHeight;
	private boolean recursiveOption;

	public ThumbnailCreator(int thumbnailWidth, int thumbnailHeight,
			boolean recursiveOption) {
		super();
		this.thumbnailWidth = thumbnailWidth;
		this.thumbnailHeight = thumbnailHeight;
		this.recursiveOption = recursiveOption;
	}

	public void createThumbnails(String filePath) throws InterruptedException {
		long start = System.currentTimeMillis();
		File[] files = new File(filePath).listFiles();
		FileReader reader = new FileReader(storage, filePath);
		Thread readerThread = new Thread(reader);
		Thread writerThread = new Thread(new ImageWriter(storage, readerThread,
				thumbnailWidth, thumbnailHeight));
		readerThread.start();
		writerThread.start();
		for (File file : files) {
			if (file.isDirectory() && recursiveOption) {
				createThumbnails(file.toString());
			}
		}
		readerThread.join();
		writerThread.join();
		System.out.println(System.currentTimeMillis() - start);
	}
}
