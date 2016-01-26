package monday.blockingqueue;

public class App {
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new BlockingQueue<>();
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 0;
				while (true) {
					bq.put(counter++);
				}

			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("Taken: " + bq.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
