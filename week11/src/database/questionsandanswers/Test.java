package database.questionsandanswers;

import java.sql.SQLException;

public class Test {
	private DatabaseManager dbManager;

	public Test() {
		dbManager = new DatabaseManager();
	}

	public void start() {
		Player p = null;
		try {
			p = new Login().loginOrRegister();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbManager.loadQuestions(p);
	}
}
