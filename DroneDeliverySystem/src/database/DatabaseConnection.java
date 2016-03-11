package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private final static String URL = "jdbc:mysql://localhost:3306/DroneDeliverySystem";
	private final static String USER = "root";
	private final static String PASSWORD = "pla6il0t0";
	private static DatabaseConnection instance = null;
	private static Connection connection = null;

	private DatabaseConnection() {

	}

	public static DatabaseConnection getInstance() {
		if (instance == null) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return new DatabaseConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
