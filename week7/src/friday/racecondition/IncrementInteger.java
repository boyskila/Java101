package friday.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementInteger {
	private AtomicInteger counter = new AtomicInteger();

	// private int count = 0;

	// private synchronized void increment(){
	// count++;
	// }

	private void threadsRacing() {
		Thread first = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2_000_000; i++) {
					counter.incrementAndGet();
					// increment();
				}

			}
		});
		Thread second = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2_000_000; i++) {
					counter.incrementAndGet();
					// increment();
				}

			}
		});
		first.start();
		second.start();
		try {
			first.join();
			second.join();
		} catch (InterruptedException e) {
			System.err.println(e.getCause());
		}
	}

	public static void main(String[] args) {
		IncrementInteger incr = new IncrementInteger();
		incr.threadsRacing();
		System.out.println("Counter: " + incr.getCount());
	}

	public AtomicInteger getCount() {
		return counter;
	}
}
