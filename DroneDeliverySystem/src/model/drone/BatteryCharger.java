package model.drone;

public class BatteryCharger extends Thread {
	private static final long TIME = 0;
	private Battery battery;

	public BatteryCharger(Battery battery) {
		this.battery = battery;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (!battery.isFull()) {
			battery.addUnit();
			try {
				Thread.currentThread().sleep(TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
