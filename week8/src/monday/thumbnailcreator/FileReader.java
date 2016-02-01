package monday.thumbnailcreator;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileReader implements Runnable {
	private ImageStorage<Image> storage;
	private String path;

	public FileReader(ImageStorage<Image> paths, String path) {
		super();
		this.storage = paths;
		this.path = path;
	}

	@Override
	public void run() {
		try {
			walkDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void walkDirectory() throws IOException {
		File[] files = new File(path).listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("JPG");
			}
		});
		for (File file : files) {
			storage.putImage(new Image(file.toString(), 150, 150));
			System.out.println("Reader read");
		}
	}
}
