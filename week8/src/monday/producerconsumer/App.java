package monday.producerconsumer;

import monday.producerconsumer.SyncValueStorage.ConsumingType;

public class App {

	public static void main(String[] args) throws InterruptedException {
		try {
			SyncValueStorage<Integer> bq = new SyncValueStorage<>();
			Thread producer = new ProducerThread(bq);
			Thread consumer = new ConsumerThread(bq, ConsumingType.GET_FIRST);
			Thread consumer2 = new ConsumerThread(bq, ConsumingType.GET_LAST);
			producer.start();
			consumer.start();
			consumer2.start();

			producer.join();
			consumer.join();
			consumer2.join();
		} finally {

			System.out.println("OVER");
		}
	}

}
