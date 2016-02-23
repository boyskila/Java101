package database.questionsandanswers;

import java.util.HashMap;
import java.util.Map;

public class QueryConstants {
	protected static final String GET_USER = "SELECT * FROM participant WHERE name = ? and age= ?;";
	protected final static String RANDOM_QUESTIONS = "SELECT * FROM questions ORDER BY RAND() LIMIT 10";
	protected static final String REGISTER_PARTICIPANT = "INSERT INTO participant (name, age, points) VALUES (?, ?, ?)";
	protected static final String UPDATE_RESULT = "UPDATE participant SET points=? WHERE name= ? and age= ?";
	public static final String GET_ALL_PARTICIPANTS = "SELECT * FROM participant;";
	protected static final Map<String, Integer> ANSWERS = new HashMap<String, Integer>() {
		protected static final long serialVersionUID = 1L;
		{
			put("a", 3);
			put("b", 4);
			put("c", 5);
			put("d", 6);
			put("e", 7);
		}
	};
}
