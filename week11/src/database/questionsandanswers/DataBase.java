package database.questionsandanswers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	private final static String URL = "jdbc:mysql://localhost:3306/IQTest";
	private final static String USER = "root";
	private final static String PASSWORD = "******";
	private static DataBase instance = null;
	private static Connection connection = null;

	private DataBase() {

	}

	public static DataBase getInstance() {
		if (instance == null) {
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				System.err.println("Message: " + e.getMessage());
			}
			return new DataBase();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
}
