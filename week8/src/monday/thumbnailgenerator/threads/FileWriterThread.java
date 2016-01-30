package monday.thumbnailgenerator.threads;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class FileWriterThread extends Thread {
	private Map<BufferedImage, File> map;

	public FileWriterThread(Map<BufferedImage, File> map) {
		super();
		this.map = map;
	}

	@Override
	public void run() {
		synchronized (map) {
			while (map.isEmpty()) {
				map.notifyAll();
			}
			try {
				int count = 0;
				for (Map.Entry<BufferedImage, File> entry : map.entrySet()) {
				//	System.out.println(entry.getValue());
					BufferedImage image = entry.getKey();
					File path = entry.getValue();
					File thumbnail = new File(path + "/img" + count++);
					System.out.println(thumbnail.getAbsolutePath());
					BufferedImage thumbImg = Scalr.resize(image,
							Method.QUALITY, Mode.AUTOMATIC, 150, 150,
							Scalr.OP_ANTIALIAS);
					ImageIO.write(thumbImg, "png", thumbnail);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
