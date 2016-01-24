package friday.oracleexamples.dropmessage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
	public static void main(String[] args) {
		Drop drop = new Drop();
		Thread producer = new Thread(new Producer(drop));
		Thread consumer = new Thread(new Consumer(drop));
		producer.start();
		consumer.start();
		Lock lock = new ReentrantLock();
	}
}
