package com.boyko.model;

public class CityModel implements Comparable<CityModel> {
	private String name;
	private long id;
	// private WeatherForecast weather;

	public CityModel(String name, long id) {
		super();
		this.setName(name);
		this.setId(id);
	}

	public CityModel() {
		
	}

	

	public CityModel(String string) {
		name = string;
	}

	@Override
	public int compareTo(CityModel o) {
		return this.getName().compareTo(o.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
