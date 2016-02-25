package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.drone.Drone;
import model.drone.Task;
import model.drone.specification.AmericanDroneSpecification;

public class RequestManager {
	private static List<Drone> drones = new ArrayList<>();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Drone d = new Drone(new AmericanDroneSpecification());
			d.setId(i);
			drones.add(d);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("list drones");
		for (Drone drone : drones) {
			System.out.println(drone);
		}
		System.out.println("Choose drone: ");
		int id = Integer.parseInt(sc.nextLine());
		Task deliverySugarTask = new Task(new MatrixLocation(1900, 1000), new Product(1, "Peper", 1, 10));
		Drone drone = drones.get(id);
		drone.asignTask(deliverySugarTask);
		drone.start();
		sc.close();
		try {
			drone.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(drone.getBattery().getLevel());
		// Drone americanDrone = new Drone(new AmericanDroneSpecification(),
		// deliverySugarTask);
		// americanDrone.start();
	}
}
