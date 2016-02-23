package database.questionsandanswers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResourceKiller {
	public ResourceKiller(Scanner sc, PreparedStatement preparedStatment, ResultSet resultSet, Connection connection) {
		closeConnection(connection);
		closeResultSet(resultSet);
		closeStatment(preparedStatment);
		closeScanner(sc);
	}

	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeScanner(Scanner sc) {
		if (sc != null) {
			sc.close();
		}
	}

	private void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void closeStatment(PreparedStatement preparedStatment) {
		if (preparedStatment != null) {
			try {
				preparedStatment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
