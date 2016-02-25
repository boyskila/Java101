package model;

import model.contract.Building;
import model.contract.Location;

public class Warehouse implements Building {
	private MatrixLocation location;

	public Warehouse(MatrixLocation location) {
		this.location = location;
	}

	@Override
	public Location getLocation() {
		return location;
	}
}
