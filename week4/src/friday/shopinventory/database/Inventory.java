package friday.shopinventory.database;

import friday.shopinventory.exceptions.ProductNotFoundException;
import friday.shopinventory.model.Order;
import friday.shopinventory.model.Order.ProductInfo;
import friday.shopinventory.model.Product;

public class Inventory extends Storage {

	public Inventory() {

	}

	public double audit() {
		double sum = 0;
		for (Product product : getAllProducts()) {
			if (product.getQuantity()>0) {
				
				sum += (product.getTotalPrice() * product.getQuantity());
			}
		}
		return sum;
	}

	public boolean requestOrder(Order order) throws ProductNotFoundException {
		for (ProductInfo<Integer, Integer> productInfo : order.getProducts()) {
			if (productInfo.getQuantity() < 0) {
				throw new ProductNotFoundException();
			}
		}
		return true;
	}
}
