package model;

public class Product {
	private int id;
	private String name;
	private float weight;
	private int quantity;

	public Product(int id, String name, float weight, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", weight=" + weight + "quantity= " + quantity + "]";
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
