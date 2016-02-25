package friday.shopinventory.database;

import java.util.ArrayList;
import java.util.List;

import friday.shopinventory.model.Product;

public class ProductDataBase {
	private List<Product> products;
	private List<Product> availableProducts;

	 private static ProductDataBase instance = new ProductDataBase();

	public ProductDataBase() {
		products = new ArrayList<>();
		products.add(new Product("Pants", 0, 25, 2, 61));
		products.add(new Product("Tv", 1, 125, 1, 49));
		products.add(new Product("Pc", 2, 1025, 3, 39));
		products.add(new Product("Tequila", 3, 7.50, 2, 43));
		products.add(new Product("Jacket", 4, 75, 3, 44));
		products.add(new Product("Beer", 5, 0.75, 10, 359));
	}

	public static ProductDataBase getInstance() {
		return instance;
	}

	public List<Product> getAvailableProducts() {
		availableProducts = new ArrayList<>();
		for (Product product : products) {
			if (product.getQuantity() > 0) {
				availableProducts.add(product);
			}
		}
		return availableProducts;
	}

	public List<Product> getAllProducts() {
		return products;
	}
}
