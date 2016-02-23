package database.questionsandanswers;

import java.util.HashMap;
import java.util.Map;

public class AnswerOptions {
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
