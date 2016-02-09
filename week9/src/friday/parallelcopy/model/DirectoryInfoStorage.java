package friday.parallelcopy.model;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("hiding")
public class DirectoryInfoStorage<FileInfo> {
	public BlockingQueue<friday.parallelcopy.model.FileInfo> smallerFiles;
	public BlockingQueue<friday.parallelcopy.model.FileInfo> biggerFiles;

	public DirectoryInfoStorage() {
		smallerFiles = new LinkedBlockingQueue<>();
		biggerFiles = new LinkedBlockingQueue<>();
	}

	public void addToStorage(friday.parallelcopy.model.FileInfo info) {
		if (info.getSize() >= 2) {
			biggerFiles.add(info);
		} else {
			smallerFiles.add(info);
		}
	}

	@Override
	public String toString() {
		return "smallerFiles=" + smallerFiles + ", biggerFiles=" + biggerFiles;
	}

	public class SmallerTasksIterator<FileInfo> implements Iterator<FileInfo> {
		private Lock lock = new ReentrantLock();

		@Override
		public boolean hasNext() {
			return smallerFiles.size() > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public FileInfo next() {
			try {
				lock.lock();
				return (FileInfo) smallerFiles.peek();
			} finally {
				lock.unlock();
			}
		}

		@Override
		public void remove() {
			try {
				lock.lock();
				smallerFiles.remove();
			} finally {
				lock.unlock();
			}
		}
	}

	public class BiggerTasksIterator<FileInfo> implements Iterator<FileInfo> {
		private Lock lock = new ReentrantLock();

		@Override
		public boolean hasNext() {
			return biggerFiles.size() > 0;
		}

		@SuppressWarnings("unchecked")
		@Override
		public FileInfo next() {
			try {
				lock.lock();
				return (FileInfo) biggerFiles.poll();
			} finally {
				lock.unlock();
			}
		}

		@Override
		public void remove() {
			try {
				lock.lock();
				smallerFiles.remove();
			} finally {
				lock.unlock();
			}
		}
	}

	public Iterator<FileInfo> smallerTasksIterator() {
		return new SmallerTasksIterator<FileInfo>();
	}

	public Iterator<FileInfo> biggerTasksIterator() {
		return new BiggerTasksIterator<FileInfo>();
	}
}
