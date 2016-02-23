package database.questionsandanswers;

import java.sql.SQLException;

public class Test {
	private DatabaseManager dbManager;

	public Test() {
		dbManager = new DatabaseManager();
	}

	public void start() {
		try {
			Player player = new Login().loginOrRegister();
			dbManager.loadQuestions(player);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
