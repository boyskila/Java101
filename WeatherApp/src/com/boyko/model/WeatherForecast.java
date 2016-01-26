package com.boyko.model;

import org.json.JSONArray;

public class WeatherForecast {
	private JSONArray dailyForecast;

	public WeatherForecast(JSONArray dailyForecast) {
		super();
		this.dailyForecast = dailyForecast;
	}

	@Override
	public String toString() {
		return "WeatherForecast [dailyForecast=" + dailyForecast + "]";
	}
}
