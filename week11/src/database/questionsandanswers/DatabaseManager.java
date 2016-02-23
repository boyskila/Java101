package database.questionsandanswers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseManager {
	private PreparedStatement preparedStatment;
	private ResultSet resultSet;
	private Connection connection;

	private Scanner sc;

	public DatabaseManager() {
		DataBase db = DataBase.getInstance();
		connection = db.getConnection();
		sc = new Scanner(System.in);
	}

	public void loadQuestions(Player player) {
		try {
			printRanking();
			preparedStatment = connection.prepareStatement(QueryConstants.RANDOM_QUESTIONS);
			resultSet = preparedStatment.executeQuery();
			showQuestions(player);
			// compare player best result and player current result.Insert
			// result in the database
			updateResult(player);
			System.out.printf("Test finished! %s you have %d points", player.getName(), player.getCurrentPoints());
			printRanking();
		} catch (SQLException e) {
			System.err.println("Message: " + e.getMessage());
		} finally {
			new ResourceKiller(sc, preparedStatment, resultSet, connection);
		}
	}

	private void showQuestions(Player player) throws SQLException {
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
			// show answer options
			answerOptions(resultSet);
			System.out.println("Select option");
			int answerIndex = 0;
			// loop until selected option not match a, b, c, d, e
			while (answerIndex < 3 || answerIndex > 7) {
				System.out.println("select answer: ");
				// option - a,b,c,d or e
				String option = sc.next();
				try {
					answerIndex = QueryConstants.ANSWERS.get(option);
				} catch (Exception e) {
					System.out.println("No such option: " + option + "\n");
				}
			}
			checkAnswer(player, answerIndex);
		}
	}

	private void checkAnswer(Player player, int answerIndex) throws SQLException {
		// get participant answer
		String participantAnswer = resultSet.getString(answerIndex);
		// get correct answer from database
		String correctAnswer = resultSet.getString(8);
		// check
		if (participantAnswer.equals(correctAnswer)) {
			System.out.println("Correct");
			player.addPoints(resultSet.getInt(10));
		} else {
			System.out.println("====================================");
			System.out.println("NOT correct");
			System.out.println("Correct answer is: " + correctAnswer);
			System.out.println("Explanation: " + resultSet.getString(9));
			System.out.println("====================================");
		}

	}

	private void updateResult(Player player) throws SQLException {
		if (player.getBestResult() < player.getCurrentPoints()) {
			player.setBestResult(player.getCurrentPoints());
			preparedStatment = connection.prepareStatement(QueryConstants.UPDATE_RESULT);
			preparedStatment.setInt(1, player.getCurrentPoints());
			preparedStatment.setString(2, player.getName());
			preparedStatment.setInt(3, player.getAge());
			preparedStatment.execute();
		}
	}

	private void printRanking() throws SQLException {
		System.out.println("RankList");
		System.out.println("====================================");
		preparedStatment = connection.prepareStatement(QueryConstants.GET_ALL_PARTICIPANTS);
		resultSet = preparedStatment.executeQuery();
		int count = 1;
		while (resultSet.next()) {
			System.out.println(count++ + " place: " + resultSet.getString(2) + " bestResult: " + resultSet.getInt(4));
		}
	}

	private void answerOptions(ResultSet rs) throws SQLException {
		// in assci 97=a,98=b,99=c.....print answer options
		for (int i = 97, a = 3; i <= 101; i++, a++) {
			if (rs.getString(a) != null) {
				System.out.println((char) i + ": " + rs.getString(a));
			}
		}
	}
}
