package model.drone;

import model.MyLogger;
import model.Product;
import model.contract.Location;

public class Task implements Runnable {

	private Location location;
	private Product product;

	public Task(Location location, Product product) {
		this.location = location;
		this.product = product;
	}

	@Override
	public void run() {
		product.setQuantity(product.getQuantity() - 1);
		MyLogger.createLog(this);
	}

	public Location getLocation() {
		return location;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "Task [location=" + location + ", product=" + product + "]";
	}
}
