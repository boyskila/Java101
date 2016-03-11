package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DatabaseConnection;
import database.Warehouse;
import model.contract.Request;

public class Supply implements Request {
	// insert product if not exist or update product if exist
	private static final String QUERY = "insert into products (name, weight, quantity) "
			+ "values (?, ?, ?) on duplicate key update quantity=quantity + values(quantity)";
	private PreparedStatement preparedStatment;
	private Connection connection;

	private Warehouse warehouse;

	public Supply(Warehouse warehouse) {
		this.warehouse = warehouse;
		prepareStatment();
	}

	private void prepareStatment() {
		DatabaseConnection db = DatabaseConnection.getInstance();
		connection = db.getConnection();
		try {
			preparedStatment = connection.prepareStatement(QUERY);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void accept(String request) throws SQLException {
		String[] req = splitRequest(request);
		for (int i = 1; i < req.length - 2; i += 3) {

			String productName = req[i];
			float productWeight = Float.parseFloat(req[i + 1]);
			int productQuantity = Integer.parseInt(req[i + 2]);

			preparedStatment.setString(1, productName);
			preparedStatment.setFloat(2, productWeight);
			preparedStatment.setInt(3, productQuantity);
			preparedStatment.execute();

			// pass product to warehouse
			warehouse.addProduct(new Product(productName, productWeight, productQuantity));
		}
		connection.close();
	}

	private String[] splitRequest(String request) {
		return request.split(" ");
	}
}
