package model;

import model.contract.Location;

public class MatrixLocation implements Location {

	private int x;
	private int y;

	public MatrixLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int calculateDistance(Location location) {
		int x = (int) Math.pow((this.x - location.getX()), 2);
		int y = (int) Math.pow((this.y - location.getY()), 2);
		return (int) Math.sqrt(x + y);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
}
