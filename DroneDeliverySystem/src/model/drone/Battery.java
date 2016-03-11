package model.drone;

import model.drone.specification.DroneSpecifications.BatterySpecifications;

public class Battery {

	private BatterySpecifications batterySpecs;
	private int level;

	public Battery(BatterySpecifications batterySpecs) {
		this.batterySpecs = batterySpecs;
		level = batterySpecs.getBatteryCapacity();
	}

	public boolean isFull() {
		return level == batterySpecs.getBatteryCapacity();
	}

	public boolean isEmpty() {
		return level == 0;
	}

	public void charge() {
		new BatteryCharger(this).start();
	}

	public void discharge(int distance) {
		level -= (batterySpecs.getDischargingRate() * distance);
	}

	public void addUnit() {
		level += batterySpecs.getChargingRate();
	}

	public int getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return "Battery [batterySpecs=" + batterySpecs + "]";
	}
}
