package monday.thumbnailcreator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class ImageWriterThread implements Runnable {
	private BlockingQueue<Image> paths;

	public ImageWriterThread(BlockingQueue<Image> paths) {
		super();
		this.paths = paths;
	}

	@Override
	public void run() {
		AtomicInteger count = new AtomicInteger(0);
		while (!paths.isEmpty()) {
			Image img = paths.remove();
			BufferedImage thumbImg = Scalr.resize(img.getImage(),
					Method.QUALITY, Mode.AUTOMATIC, 150, 150,
					Scalr.OP_ANTIALIAS);
			try {
				ImageIO.write(thumbImg, "png", new File(img.getPathToCopy()
						+ "/img" + count.incrementAndGet()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
