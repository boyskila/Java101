package model;

import java.util.HashMap;
import java.util.Map;

import model.contract.Location;

public class Order {
	private int id;
	private String date;
	private String time;
	private Map<Product, Integer> products;
	private Location deliveryLocation;
	private int weight;

	public Order(int id, String date, String time, Location deliveryLocation) {
		this.id = id;
		this.date = date;
		this.time = time;
		products = new HashMap<>();
		this.deliveryLocation = deliveryLocation;
	}

	public void addProducts(Product product, int quantity) {
		// calculate order weight
		weight += product.getWeight() * quantity;
		products.put(product, quantity);
	}

	public int getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public Location getDeliveryLocation() {
		return deliveryLocation;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return products.toString();
	}
}
