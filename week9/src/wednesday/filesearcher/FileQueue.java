package wednesday.filesearcher;

import java.io.File;
import java.util.concurrent.LinkedBlockingDeque;

public class FileQueue {
	private LinkedBlockingDeque<File> ll = new LinkedBlockingDeque<>();

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public File getFile() {

		return ll.remove();
	}

	public void addFile(File file) {

		ll.add(file);

	}

}
