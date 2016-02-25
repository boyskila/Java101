package friday.shopinventory.model;

import java.util.ArrayList;
import java.util.List;

import friday.shopinventory.database.Inventory;
import friday.shopinventory.exceptions.ProductNotFoundException;
import friday.shopinventory.exceptions.ProductOutOfStockException;
import friday.shopinventory.model.Order.ProductInfo;

public class Customer {

	private String name;
	private int id;
	private List<Order> orders;

	public Customer(String name, int id) {
		this.name = name;
		this.id = id;
		orders = new ArrayList<>();
	}

	public boolean makeOrder(int... productsId)
			throws ProductNotFoundException, ProductOutOfStockException {
		Order order = new Order(productsId);
		orders.add(order);
		return true;
	}

	public void showOrder() {
		System.out.printf("%s purchase this products:%n", name);
		Inventory inventory = new Inventory();
		for (Order order : orders) {
			List<ProductInfo<Integer, Integer>> info = order.getProducts();
			for (ProductInfo<Integer, Integer> product : info) {
				System.out.println(inventory.getAllProducts()
						.get(product.getId()).getProductName()
						+ product);
			}
		}
	}

	public List<Order> getOrders() {
		return orders;
	}

	public int getId() {
		return id;
	}
}
