package database.questionsandanswers;

public class QueryConstants {
	protected static final String GET_USER = "SELECT * FROM participant WHERE name = ? and age= ?;";
	protected final static String RANDOM_QUESTIONS = "SELECT * FROM questions ORDER BY RAND() LIMIT 10";
	protected static final String REGISTER_PARTICIPANT = "INSERT INTO participant (name, age, points) VALUES (?, ?, ?)";
	protected static final String UPDATE_RESULT = "UPDATE participant SET points=? WHERE name= ? and age= ?";
	public static final String GET_ALL_PARTICIPANTS = "SELECT * FROM participant ORDER BY points DESC;";
}
