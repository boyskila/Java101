package friday.parallelcopy;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import friday.parallelcopy.model.DirectoryInfoStorage;
import friday.parallelcopy.model.FileInfo;
import friday.parallelcopy.thread.FileDispatcher;
import friday.parallelcopy.thread.ThreadDispatcher;

public class Main {
	public static ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> storage = new ConcurrentHashMap<>();
	private static final File TARGET = new File(
			"/home/boyko/Desktop/testDir/dir");
	private static final String START_DIRECTORY = "/home/boyko/Desktop/dir";

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		FileDispatcher fileDispatcher = new FileDispatcher(
				Paths.get(START_DIRECTORY), TARGET, storage);
		storage.put(START_DIRECTORY, new DirectoryInfoStorage<FileInfo>());
		
		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>>> future = pool
				.submit(fileDispatcher);
		
		ThreadDispatcher threadDispatcher = new ThreadDispatcher(future.get());
		threadDispatcher.start();
		threadDispatcher.join();
		
		System.exit(0);
	}
}
