package friday.parallelcopy.thread;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import friday.parallelcopy.model.DirectoryInfoStorage;
import friday.parallelcopy.model.FileInfo;
import friday.parallelcopy.task.BiggerTaskSolver;
import friday.parallelcopy.task.SmallTaskSolver;

public class ThreadDispatcher extends Thread {

	private ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> storage;

	public ThreadDispatcher(
			ConcurrentHashMap<String, DirectoryInfoStorage<FileInfo>> storage) {
		super();
		this.storage = storage;
	}

	@Override
	public void run() {
		for (Entry<String, DirectoryInfoStorage<FileInfo>> string : storage
				.entrySet()) {
			System.out.println("Directory " + string.getKey() + " ");
			SmallTaskSolver smallerTaskSolver = new SmallTaskSolver(
					string.getValue());
			BiggerTaskSolver biggerTaskSolver = new BiggerTaskSolver(
					string.getValue());
			if (string.getValue().smallerFiles.size() > 5) {
				ExecutorService pool2 = Executors.newFixedThreadPool(3);
				for (int i = 0; i < 2; i++) {
					pool2.execute(smallerTaskSolver);
				}
			} else {
				Thread t1 = new Thread(smallerTaskSolver);
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (string.getValue().biggerFiles.size() > 5) {
				ExecutorService pool2 = Executors.newFixedThreadPool(3);
				for (int i = 0; i < 2; i++) {
					pool2.execute(biggerTaskSolver);
				}
			} else {
				Thread t1 = new Thread(biggerTaskSolver);
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
