package model.drone.specification;

public abstract class DroneSpecifications {
	public abstract class BatterySpecifications {
		protected int batteryCapacity;
		protected int chargingRate;
		protected static final int DISCHARGING_RATE = 1;

		public int getBatteryCapacity() {
			return batteryCapacity;
		}

		public int getChargingRate() {
			return chargingRate;
		}

		public int getDischargingRate() {
			return DISCHARGING_RATE;
		}

		@Override
		public String toString() {
			return "BatterySpecifications [batteryCapacity=" + batteryCapacity + ", chargingRate=" + chargingRate + "]";
		}
	}

	protected int weightCapacity;
	protected final static int LOADING_RATE = 60;
	protected final static int UNLOADING_RATE = 60;

	public abstract BatterySpecifications getBatterySpecifications();

	@Override
	public String toString() {
		return "DroneSpecifications [weightCapacity=" + getWeightCapacity() + "loadingRate= " + LOADING_RATE
				+ "unLoadingRate= " + UNLOADING_RATE + "]";
	}

	public int getWeightCapacity() {
		return weightCapacity;
	}
}
