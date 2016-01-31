package monday.thumbnailcreator;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class FileReader {
	private BlockingQueue<Image> paths;
	private boolean isRecursiveWalk;
	private String path;

	public FileReader(BlockingQueue<Image> paths, String path,
			boolean isRecursiveWalk) {
		super();
		this.paths = paths;
		this.path = path;
		this.isRecursiveWalk = isRecursiveWalk;
	}

	public void read() {
		if (isRecursiveWalk) {
			try {
				recursiveWalk();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				walkDirectory();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void recursiveWalk() throws IOException {
		Files.walk(Paths.get(path))
				.filter(path -> Files.isRegularFile(path)
						&& path.toString().endsWith("JPG"))
				.forEach(
						path -> paths.add(new Image(path.toString(), 150, 150)));
	}

	private void walkDirectory() throws IOException {
		File[] files = new File(path).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("JPG");
			}
		});
		for (File file : files) {
			paths.add(new Image(file.toString(), 150, 150));
		}
	}
}
