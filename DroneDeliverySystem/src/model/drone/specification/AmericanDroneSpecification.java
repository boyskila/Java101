package model.drone.specification;

public class AmericanDroneSpecification extends DroneSpecifications {

	public class AmericanBattery extends BatterySpecifications {
		public AmericanBattery() {
			chargingRate = 5;
			batteryCapacity = 2000;
		}
	}

	public AmericanDroneSpecification() {
		weightCapacity = 500;
	}

	@Override
	public BatterySpecifications getBatterySpecifications() {
		return new AmericanBattery();
	}
}
