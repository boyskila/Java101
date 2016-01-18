package friday;

import friday.tests.SmsDecoderTests;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.textui.TestRunner;

public class Task33_SmsDecoder {
	/*
	 * Condition at:
	 * https://github.com/HackBulgaria/Programming101-Java/tree/master/week01
	 */
	static final String[] BUTTONS = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static int countButtonClicks(int clicks, int[] buttons) {
		int count = 1;
		if (buttons[clicks] == 0) {
			return count;
		}
		while (clicks < buttons.length - 1 && buttons[clicks] == buttons[clicks + 1]) {
			count++;
			clicks++;
		}
		return count;
	}

	public static char getLetter(String buttonContent, int buttonClicks) {
		int letterPosition = buttonClicks % buttonContent.length();
		if (letterPosition == 0) {
			// 0 is the last letter on the button
			letterPosition = buttonContent.length();
		}
		return buttonContent.charAt(letterPosition - 1);
	}

	public static String numbersToMessage(int[] buttons) {
		StringBuilder result = new StringBuilder();
		int buttonClicks = 1;
		boolean toUpperCase = false;
		for (int btn = 0; btn < buttons.length; btn += buttonClicks) {
			// current button
			int button = buttons[btn];
			// count how many times is clicked
			buttonClicks = countButtonClicks(btn, buttons);
			if (button == 1) {
				// switch to upperCase mode
				toUpperCase = true;
				continue;
			}
			if (button != -1) {
				// get all letters at the button
				String buttonContent = BUTTONS[button];
				// find the right one
				char letter = getLetter(buttonContent, buttonClicks);
				if (toUpperCase) {
					letter = Character.toUpperCase(letter);
					toUpperCase = false;
				}
				result.append(letter);
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		TestRunner.run(testAdapter());
	}

	public static Test testAdapter() {
		return new JUnit4TestAdapter(SmsDecoderTests.class);
	}
}
