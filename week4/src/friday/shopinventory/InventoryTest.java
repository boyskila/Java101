package friday.shopinventory;

import friday.shopinventory.database.Inventory;
import friday.shopinventory.exceptions.ProductNotFoundException;
import friday.shopinventory.exceptions.ProductOutOfStockException;
import friday.shopinventory.model.Customer;
import friday.shopinventory.model.PayDesk;

public class InventoryTest {

	public static void main(String[] args) throws ProductNotFoundException,
			ProductOutOfStockException {
		Customer customer = new Customer("Gosho", 1);
		System.out.println("Submit order: " + customer.makeOrder(2, 3));
		System.out.println("Submit order: " + customer.makeOrder(1, 2));
		System.out.println("Submit order: " + customer.makeOrder(5, 4));
		Customer customer2 = new Customer("Pesho", 2);
		customer.showOrder();
		// product with id:2 is out of stock so ... ProductOutOfStockException
		System.out.println("Submit order: " + customer2.makeOrder(2, 2, 4, 5));
		customer2.showOrder();
		System.out.println();
		System.out.println(new Inventory().audit());
		PayDesk payDesk = new PayDesk(customer.getOrders());
		System.out.println(payDesk.orderAudit());
	}
}
