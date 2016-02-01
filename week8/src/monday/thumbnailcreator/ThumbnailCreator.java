package monday.thumbnailcreator;

import java.io.File;

public class ThumbnailCreator {
	@SuppressWarnings("unchecked")
	private static ImageStorage<Image> storage = (ImageStorage<Image>) ImageStorage.getInstance();
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
		Thread t = new Thread(new FileReader(storage, filePath));
		Thread t1 = new Thread(new ImageWriterThread(storage, t,
				thumbnailWidth, thumbnailHeight), "Writer");
		t.start();
		t1.start();
		for (File file : files) {
			if (file.isDirectory() && recursiveOption) {
				createThumbnails(file.toString());
			}
		}
		t.join();
		t1.join();
		System.out.println(System.currentTimeMillis() - start);
	}
}
