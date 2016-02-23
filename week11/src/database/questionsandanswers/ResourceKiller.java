package database.questionsandanswers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResourceKiller {
	public ResourceKiller(PreparedStatement preparedStatment, ResultSet resultSet, Connection connection) {
		closeConnection(connection);
		closeResultSet(resultSet);
		closeStatment(preparedStatment);
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
