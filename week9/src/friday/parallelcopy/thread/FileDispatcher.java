package friday.parallelcopy.thread;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import friday.parallelcopy.model.DirectoryInfoStorage;
import friday.parallelcopy.model.FileInfo;

public class FileDispatcher implements
		Callable<ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>>> {

	private final Path dir;
	private File target;
	private ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> storage;

	public FileDispatcher(Path dir, File target,
			ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> storage) {
		this.dir = dir;
		this.storage = storage;
		this.target = target;
	}

	@Override
	public ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> call() {
		try {
			Files.walkFileTree(dir, new DirectoryWalker());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return storage;
	}

	public void print() {
		for (Entry<String, DirectoryInfoStorage<FileInfo>> path : storage
				.entrySet()) {
			System.out.println("Directory " + path.getKey());
			System.out.println("VALUE " + path.getValue());
			System.out.println();
		}
	}

	public class DirectoryWalker extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult preVisitDirectory(Path dir,
				BasicFileAttributes attrs) throws IOException {
			List<FileDispatcher> walks = new ArrayList<>();
			if (!dir.equals(FileDispatcher.this.dir)) {
				File dirToCreate = new File(target + "/" + dir.getFileName());
				if (!dirToCreate.exists()) {
					dirToCreate.mkdirs();
				}
				FileDispatcher w = new FileDispatcher(dir, dirToCreate, storage);
				w.call();
				walks.add(w);
				return FileVisitResult.SKIP_SUBTREE;
			} else {
				return FileVisitResult.CONTINUE;
			}
		}

		@Override
		public FileVisitResult visitFile(Path f, BasicFileAttributes attrs)
				throws IOException {
			File file = f.toFile();
			String parentDir = file.getParent();
			if (!storage.containsKey(parentDir)) {
				storage.put(parentDir, new DirectoryInfoStorage<FileInfo>());
			}
			float fileSize = file.length() / (float) (1024 * 1024);
			File fileName = new File(target + "/" + file.getName());
			storage.get(parentDir).addToStorage(
					new FileInfo(file, fileName, fileSize));
			return FileVisitResult.CONTINUE;
		}
	}
}
