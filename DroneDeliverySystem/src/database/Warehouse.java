package database;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.Order;
import model.Product;
import model.contract.Location;

public class Warehouse {
	private Location location;
	private BlockingQueue<Product> products;

	public Warehouse(Location location) {
		products = new LinkedBlockingQueue<>();
		this.location = location;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

}
