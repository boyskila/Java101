package model;

import model.contract.Location;
import model.contract.Request;

public class Delivery implements Request {
	private Order order;
	

	@Override
	public void accept(String request) {
		setOrder(prepareOrder(request));
	}

	private void manageOrders() {

	}

	private Order prepareOrder(String request) {
		String[] req = request.split(" ");
		int id = Integer.parseInt(req[1]);
		String date = req[2];
		String time = req[3];
		// extract id, date, time and location and create a new Order
		Order order = new Order(id, date, time, getLocation(req[4]));
		// get Products from request and add them to the order object
		for (int i = 5; i < req.length; i += 2) {
			int quantity = Integer.parseInt(req[i + 1]);
			order.addProducts(new Product(req[i],0,0), quantity);
		}
		// new order is ready for the drone
		return order;
	}

	private Location getLocation(String location) {
		// parse location
		String[] loc = location.split(",");
		int x = Integer.parseInt(loc[0]);
		int y = Integer.parseInt(loc[1]);
		return new MatrixLocation(x, y);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
