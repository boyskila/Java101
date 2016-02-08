package wednesday.measurementtool;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Memory {
	private static final int CAPACITY = 1000;
	private LinkedList<Integer> list = new LinkedList<>();
	private final Lock lock = new ReentrantLock();
	private final Condition bufferNotFull = lock.newCondition();
	private final Condition bufferNotEmpty = lock.newCondition();

	public Memory() {

	}

	public void put(int data) {
		lock.lock();
		try {
			while (list.size() == CAPACITY) {
				try {
					bufferNotEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			boolean isAdded = list.add(data);
			if (isAdded) {
				bufferNotFull.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

	public int get() {
		lock.lock();
		Integer value = null;
		try {
			while (list.isEmpty()) {
				try {
					bufferNotFull.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			value = list.pollFirst();
			if (value != null) {
				bufferNotEmpty.signalAll();
			}
		} finally {
			lock.unlock();
		}
		return value;
	}

	public int size() {
		return list.size();
	}
}
