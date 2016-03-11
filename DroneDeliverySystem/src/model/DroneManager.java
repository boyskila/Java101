package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.contract.Location;
import model.drone.Drone;
import model.drone.Task;
import model.drone.specification.DroneSpecifications;

public class DroneManager {

	List<Drone> drones = new ArrayList<>();
	private Location warehouse;
	private Task task;

	public DroneManager(Location wharehouse, Task task) {
		this.warehouse = wharehouse;
		this.task = task;
	}

	public void prepareDrones(DroneSpecifications specs, int droneCount) {
		for (int i = 0; i < droneCount; i++) {
			drones.add(new Drone(specs));
		}
	}

	public void dispatchDrone() {
		Drone drone = getDrone();

		if (checkDroneSpecification(drone, task)) {
			drone.asignTask(task);
			drone.start();
		} else {

			Map<Product, Integer> products = task.getProduct();
			for (Map.Entry<Product, Integer> entry : products.entrySet()) {

			}
			int dronesWeightCapacity = drone.getSpecifications().getWeightCapacity();
			List<Task> tasks = splitTask(dronesWeightCapacity, task);
		}

	}

	private List<Task> splitTask(int dronesWeightCapacity, Task task) {

		return null;
	}

	private boolean checkDroneSpecification(Drone drone, Task task) {

		DroneSpecifications droneSpecs = drone.getSpecifications();
		int taskWeight = getTaskWeight(task);

		return droneSpecs.getWeightCapacity() < taskWeight ? false : true;
	}

	private int getTaskWeight(Task task) {
		int weight = 0;
		Map<Product, Integer> products = task.getProduct();
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			weight += entry.getValue();
		}
		return weight;
	}

	private Drone getDrone() {
		if (!drones.isEmpty()) {
			return drones.remove(drones.size() - 1);
		}
		return null;
	}
}
