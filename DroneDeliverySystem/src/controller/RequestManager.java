package controller;

import java.sql.SQLException;

import database.Warehouse;
import model.Delivery;
import model.Supply;
import model.contract.Request;

public class RequestManager {
	private Warehouse warehouse;

	public RequestManager(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void manageRequest(String query) {
		Request request = null;
		// parse string and determine type of request
		String requestType = guessRequest(query);
		switch (requestType) {
		case "supply":
			/*
			 * Update existing records or add new in the DroneDeliverySystem
			 * database
			 */
			request = new Supply(warehouse);
			break;
		case "delivery":
			/* Convert String to Order object */
			request = new Delivery();
			break;
		default:
			break;
		}
		try {
			// flow goes here
			request.accept(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	private String guessRequest(String query) {
		// get first word from request
		return query.split(" ")[0];
	}
}
