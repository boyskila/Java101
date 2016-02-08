package wednesday.filesearcher;

import java.io.File;

public class DirectoryWalkerTask implements Runnable {
	private DirectoryQueue dirdb;
	private FileQueue filedb;

	public DirectoryWalkerTask(DirectoryQueue dirdb, FileQueue filedb) {
		this.filedb = filedb;
		this.dirdb = dirdb;
	}

	@Override
	public void run() {
		while (!dirdb.isEmpty()) {
			File[] dir = dirdb.getDir().listFiles();
			extractFiles(dir);
		}

	}

	private void extractFiles(File[] dir) {
		for (File file : dir) {
			if (file.isDirectory()) {
				dirdb.addDir(file);
			} else {
				filedb.addFile(file);
			}
		}

	}
}
