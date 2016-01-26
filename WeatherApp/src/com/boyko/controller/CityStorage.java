package com.boyko.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.boyko.model.CityModel;
import com.boyko.model.WeatherForecast;

public class CityStorage {
	private Map<String, WeatherForecast> jsonMap;
	private List<String> cities;
	private static final String PATH = "city.list.json";
	private List<CityModel> dataBase;
	// @Autowired
	// private Resource contents;

	public List<CityModel> getDataBase() {
		return dataBase;
	}

	public CityStorage() throws IOException {
		super();
		// final DefaultResourceLoader loader = new DefaultResourceLoader();
		Resource res = new ClassPathResource(PATH);
		File f = res.getFile();
		cities = Files.readAllLines(f.toPath());

		jsonMap = new HashMap<>();
		convertInputJsonList();
	}

	// @PostConstruct
	// final public List<String> load() throws IOException {
	//
	// }

	private void convertInputJsonList() {
		dataBase = new ArrayList<>();
		for (String city : cities) {
			JSONObject obj = new JSONObject(city);

			dataBase.add(new CityModel(obj.getString("name").toLowerCase(), obj.getLong("_id")));
			// System.out.println(obj);
			// WeatherForecast forecast = new WeatherForecast((JSONArray)
			// obj.get("list"));
			// jsonMap.put(obj.getString("name").toLowerCase(), forecast);
		}
		Collections.sort(dataBase);
	}

	public WeatherForecast getCityForecast(String name) {
		return jsonMap.get(name.toLowerCase());
	}

	public int getCity(CityModel name) {
		return Collections.binarySearch(dataBase, name, new Comparator<CityModel>() {
			@Override
			public int compare(CityModel o1, CityModel o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	public static void main(String[] args) throws IOException {
		CityStorage st =new CityStorage();
	//	int index =st.getCity(new CityModel("london"));
	//	System.out.println(st.dataBase.get(index).getId());
	}
}
