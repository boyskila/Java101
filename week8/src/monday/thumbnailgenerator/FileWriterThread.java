package monday.thumbnailgenerator;

import java.io.IOException;

public class FileWriterThread extends Thread {
	private ThumbnailGenerator generator;

	public FileWriterThread(ThumbnailGenerator generator) {
		super();
		this.generator = generator;
	}

	@Override
	public void run() {
		try {
			generator.createThummnails();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
