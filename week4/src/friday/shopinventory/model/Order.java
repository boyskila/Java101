package friday.shopinventory.model;

import java.util.ArrayList;
import java.util.List;

import friday.shopinventory.database.Inventory;
import friday.shopinventory.exceptions.ProductNotFoundException;
import friday.shopinventory.exceptions.ProductOutOfStockException;

public class Order {
	public class ProductInfo<K, V> {
		private int id;
		private int quantity;

		public ProductInfo(int id, int quantity) {
			this.id = id;
			this.quantity = quantity;
		}

		public int getId() {
			return id;
		}

		public int getQuantity() {
			return quantity;
		}

		@Override
		public String toString() {
			return String.format("[id= %d, quantity= %d]", id, quantity);
		}

	}

	private List<ProductInfo<Integer, Integer>> products;

	public Order(int... productId) throws ProductNotFoundException,
			ProductOutOfStockException {
		Inventory inventory = new Inventory();
		products = new ArrayList<>(productId.length);
		for (int id : productId) {
			Product product = null;
			try {
				product = inventory.getAllProducts().get(id);
			} catch (Exception e) {
				throw new ProductNotFoundException();
			}
			int quantity = product.getQuantity();
			product.setQuantity(quantity - 1);
			products.add(new ProductInfo<>(id, quantity));
		}
		inventory.requestOrder(this);
	}

	public void showOrder() {
		for (ProductInfo<Integer, Integer> productInfo : products) {
			System.out.println(productInfo.id + " " + productInfo.quantity);
		}
	}

	public List<ProductInfo<Integer, Integer>> getProducts() {
		return products;
	}

	// @Override
	// public String toString() {
	// StringBuilder sb = new StringBuilder();
	// for (ProductInfo<Integer, Integer> productInfo : products) {
	// sb.append(productInfo);
	// }
	// return sb.toString();
	// }
}
