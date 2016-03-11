package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;

public class Product {
	private static final String QUERY = "select weight from products where name=?";
	private String name;
	private float weight;
	private int quantity;

	public Product(String name, float weight, int quantity) {
		this.name = name;
		this.weight = weight;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public float getWeight() {
		// ask db for product weight
		DatabaseConnection db = DatabaseConnection.getInstance();
		Connection conn = db.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(QUERY);
			st.setString(1, name);
			ResultSet set = st.executeQuery();
			set.next();
			weight = set.getFloat("weight");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return weight;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", weight=" + weight + "]";
	}
}
