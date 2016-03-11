package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import database.Warehouse;
import model.MatrixLocation;

public class Main {
	private static final String FILE = "orders.txt";

	public static void main(String[] args) {
		RequestManager rm = new RequestManager(new Warehouse(new MatrixLocation(49,49)));
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
			for (String line; (line = br.readLine()) != null;) {
				rm.manageRequest(line);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
