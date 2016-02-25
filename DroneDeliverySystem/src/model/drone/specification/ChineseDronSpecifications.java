package model.drone.specification;

public class ChineseDronSpecifications extends DroneSpecifications {

	public class ChineseBattery extends BatterySpecifications {
		public ChineseBattery() {
			chargingRate = 3;
			batteryCapacity = 1200;
		}
	}

	public ChineseDronSpecifications() {
		weightCapacity = 200;
	}

	@Override
	public BatterySpecifications getBatterySpecifications() {
		return new ChineseBattery();
	}

}
