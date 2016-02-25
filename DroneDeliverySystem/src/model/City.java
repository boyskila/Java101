package model;

import model.contract.Building;
import model.contract.Location;

public class City {
	private char[][] city;

	private static final char BUILDING_MARKER = '#';

	public City(int width, int height) {
		city = new char[width][height];
	}

	public void build(Building building) {
		Location loc = building.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		city[x][y] = BUILDING_MARKER;
	}

	public char[][] getCityMap() {
		return city;
	}

	public void printMap() {
		for (int i = 0; i < city.length; i++) {
			for (int j = 0; j < city[i].length; j++) {
				if (city[i][j] == BUILDING_MARKER) {
					System.out.print(BUILDING_MARKER);
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Building b1 = new Warehouse(new MatrixLocation(5, 10));
		Building b2 = new Warehouse(new MatrixLocation(20, 10));
		Building b3 = new Warehouse(new MatrixLocation(5, 20));
		Building b4 = new Warehouse(new MatrixLocation(1, 1));
		City c = new City(30, 22);
		c.build(b1);
		c.build(b2);
		c.build(b3);
		c.build(b4);
		c.printMap();
	}
}
