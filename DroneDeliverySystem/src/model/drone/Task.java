package model.drone;

import java.util.Map;

import model.MyLogger;
import model.Product;
import model.contract.Location;

public class Task implements Runnable {

	private Location location;
	// this map represent products in the task and their quantity
	private Map<Product, Integer> products;

	public Task(Location location, Map<Product, Integer> products) {
		this.location = location;
		this.products = products;
	}

	@Override
	public void run() {
		MyLogger.createLog(this);
	}

	public Location getLocation() {
		return location;
	}

	public Map<Product, Integer> getProduct() {
		return products;
	}

	@Override
	public String toString() {
		return "Task [location=" + location + ", product=" + products + "]";
	}
}
