package model;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import model.drone.Task;

public class MyLogger {

	private static final String PATH = "/home/boyko/Documents/test.txt";

	public static void createLog(Task task) {
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;

		try {
			fh = new FileHandler(PATH, true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logger.info(task.getProduct() + " Delivered at location " + task.getLocation());

		} catch (SecurityException | IOException message) {
			System.err.println(message);
		}
	}
}
