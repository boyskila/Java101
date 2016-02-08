package monday.thumbnailcreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageWriter implements Runnable {
	private ImageStorage<Image> storage;
	private Thread producer;
	private int thumbnailWidth;
	private int thumbnailHeight;

	public ImageWriter(ImageStorage<Image> storage, Thread producer,
			int thumbnailWidth, int thumbnailHeight) {
		super();
		this.storage = storage;
		this.producer = producer;
		this.thumbnailWidth = thumbnailWidth;
		this.thumbnailHeight = thumbnailHeight;
	}

	@Override
	public void run() {
		while (producer.isAlive() || !storage.isEmpty()) {
			if (!storage.isEmpty()) {
				createThumbnail();
			}
		}
	}

	public void createThumbnail() {

		Image img = storage.getImage();
		BufferedImage thumbImg = Scalr.resize(img.getImage(), Method.QUALITY,
				Mode.AUTOMATIC, thumbnailWidth, thumbnailHeight,
				Scalr.OP_ANTIALIAS);
		try {
			System.out.println("Writer write ");
			ImageIO.write(thumbImg, "png", new File(img.getPathToCopy()
					+ storage.storeImageAt()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
