package model.drone;

import model.MatrixLocation;
import model.contract.Location;
import model.drone.specification.DroneSpecifications;

public class Drone extends Thread {
	private Integer id;
	private Battery battery;
	private DroneSpecifications specs;
	private Location wharehouse;
	private Task taskToDo;

	public Drone(DroneSpecifications specs) {
		this.specs = specs;
		battery = new Battery(specs.getBatterySpecifications());
		wharehouse = new MatrixLocation(42, 42);
	}

	public void asignTask(Task task) {
		taskToDo = task;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Battery getBattery() {
		return battery;
	}

	public DroneSpecifications getSpecifications() {
		return specs;
	}

	private void dischargeBattery() {
		// discharge battery using formula (single battery unit/one distance
		// unit)
		int distance = taskToDo.getLocation().calculateDistance(wharehouse);
		System.out.println("Distance" + distance);
		battery.discharge(distance);
	}

	public void setWharehouseLocation(Location warehouse) {
		this.wharehouse = warehouse;
	}

	@Override
	public void run() {
		taskToDo.run();
		dischargeBattery();
	}

	@Override
	public String toString() {
		return "Drone [id=" + id + ", battery=" + battery + ", specs=" + specs + "]";
	}
}
