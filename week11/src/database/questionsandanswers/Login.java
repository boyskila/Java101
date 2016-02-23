package database.questionsandanswers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	private PreparedStatement preparedStatment;
	private ResultSet resultSet;
	private Connection connection;
	private Scanner sc;

	public Login() {
		DataBase db = DataBase.getInstance();
		connection = db.getConnection();
		sc = new Scanner(System.in);
	}

	// return null if user not exist
	private Player userExist(String name, int age) throws SQLException {
		preparedStatment = connection.prepareStatement(QueryConstants.GET_USER);
		preparedStatment.setString(1, name);
		preparedStatment.setInt(2, age);
		resultSet = preparedStatment.executeQuery();
		return resultSet.next() ? new Player(resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)) : null;
	}

	public Player loginOrRegister() throws SQLException {
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();

		System.out.println("Please enter your age: ");
		int age = Integer.parseInt(sc.nextLine());

		Player player = userExist(name, age);
		// if user is not register in the database - automatically register it
		if (player == null) {
			return registerUser(name, age);
		}
		// else get user from database
		return player;
	}

	private Player registerUser(String name, int age) {
		try {
			preparedStatment = connection.prepareStatement(QueryConstants.REGISTER_PARTICIPANT);
			preparedStatment.setString(1, name);
			preparedStatment.setInt(2, age);
			preparedStatment.setInt(3, 0);
			preparedStatment.execute();

		} catch (SQLException e) {
			new ResourceKiller(sc, preparedStatment, resultSet, connection);
			System.err.println("Message: " + e.getMessage());
		} finally {
			sc.close();
		}
		// return brand new player with best result = 0
		return new Player(name, age, 0);
	}
}