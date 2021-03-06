package wednesday.filesearcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final File PATH = new File("/home/boyko");
	private static final String NEEDLE = "Lalov";

	public static void main(String[] args) {
		List<MatchDb> matchDb = new ArrayList<MatchDb>();
		DirectoryQueue dirdb = new DirectoryQueue();
		FileQueue filedb = new FileQueue();
		dirdb.addDir(PATH);

		ExecutorService ex = Executors.newFixedThreadPool(7);

		for (int i = 0; i < 5; i++) {
			DirectoryWalkerTask task1 = new DirectoryWalkerTask(dirdb, filedb);
			ex.execute(task1);
		}
		for (int i = 0; i < 2; i++) {
			FileSearcherTask task2 = new FileSearcherTask(filedb, NEEDLE,
					matchDb);
			ex.execute(task2);
		}
		ex.shutdown();
		while (!ex.isTerminated()) {

		}
		for (MatchDb matchDb2 : matchDb) {
			System.out.println(matchDb2);
		}
	}
}
