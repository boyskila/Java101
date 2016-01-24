package friday.exercises;

public class VolatileExample implements Runnable {
	private volatile boolean flag = true;

	@Override
	public void run() {
		while (flag) {
		}
		System.out.println("I'm done!");
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileExample v = new VolatileExample();
		Thread t = new Thread(v);
		t.start();
		v.flag = false;
		Thread.sleep(1000);
		System.out.println("Set to false!");
	}
}
