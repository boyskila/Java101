package friday.exercises;

public class Devisor implements Runnable {
	private int a;
	private int b;

	public Devisor(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		devision();
	}

	private int devision() {
		return a / b;
	}
}
