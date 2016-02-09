package friday.parallelcopy.task;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

import friday.parallelcopy.model.DirectoryInfoStorage;
import friday.parallelcopy.model.FileInfo;

public class BiggerTaskSolver implements Runnable {
	private DirectoryInfoStorage<FileInfo> dirInf;

	public BiggerTaskSolver(DirectoryInfoStorage<FileInfo> dirInf) {
		this.dirInf = dirInf;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Iterator<FileInfo> it = dirInf.biggerTasksIterator();
		while (it.hasNext()) {
			FileInfo fi = it.next();
			it.remove();
			try {
				//if (!fi.getPath().exists()) {					
					Files.copy(fi.getPath().toPath(), fi.getTarget().toPath());
				//}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
