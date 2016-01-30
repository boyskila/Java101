package wednesday.codetester.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wednesday.codetester.annotations.After;

public class TestResultStorage {
	public enum TestStatus {
		PASS, NOT_PASS
	}

	protected static class ResultPair<T> {
		protected T expectedValue;
		protected T exactValue;
		protected T[] expectedArrayValue;
		protected T[] exactArrayValue;
		protected boolean isTrue;
		protected String methodName;

		public ResultPair(T expectedValue, T exactValue, boolean isTrue,
				String methodName) {
			this.expectedValue = expectedValue;
			this.exactValue = exactValue;
			this.isTrue = isTrue;
			this.methodName = methodName;
		}

		public ResultPair(T[] expectedArrayValue, T[] exactArrayValue,
				boolean isTrue, String methodName) {
			this.expectedArrayValue = expectedArrayValue;
			this.exactArrayValue = exactArrayValue;
			this.isTrue = isTrue;
			this.methodName = methodName;
		}

		public ResultPair(boolean isTrue, String methodName) {
			this.isTrue = isTrue;
			this.methodName = methodName;
		}

		@Override
		public String toString() {
			if (exactValue == null && exactArrayValue == null) {
				return "IsTrue= " + isTrue;
			} else if (exactValue != null && exactArrayValue == null) {
				return "expectedValue=" + expectedValue + ", exactValue="
						+ exactValue + " " + isTrue;
			}
			return "expectedArrayValue=" + Arrays.toString(expectedArrayValue)
					+ ", exactArrayValue=" + Arrays.toString(exactArrayValue)
					+ " " + isTrue;
		}
	}

	public static List<ResultPair<?>> resultMap = new ArrayList<>();

	@After
	public static void printMap() {
		boolean pass = true;
		String status = "";
		for (ResultPair<?> resultPair : resultMap) {
			if (resultPair.isTrue == false) {
				pass = false;
			}
			if (pass) {
				status = TestStatus.PASS.name();
				System.out.println(resultPair.methodName + " method " + status);
			} else {
				status = TestStatus.NOT_PASS.name();
				System.err.println(resultPair.methodName + " method " + status
						+ " " + resultPair);
			}
			pass = true;
		}
	}
}
