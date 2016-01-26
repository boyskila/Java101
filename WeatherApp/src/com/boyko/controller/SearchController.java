package com.boyko.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boyko.model.CityModel;

@Controller
public class SearchController {
	private CityStorage storage;

	public SearchController() throws IOException {
		storage = new CityStorage();
	}

	// 524901
	@RequestMapping("/search")
	public Model searchCity(Model model) throws IOException {
		// city.getJSONObject("city").get("name")
		int index = storage.getCity(new CityModel("sofia"));
		long cityId = storage.getDataBase().get(index).getId();
		JSONObject city = openConnection(cityId);
		// System.out.println(city.toString(4));
		// model.addAttribute("message");
		// model.put("message", new Date(city.getLong("dt")));
		model.addAttribute("url", "http://openweathermap.org/img/w/10d.png");
		return model;

	}

	private static JSONObject openConnection(long id) throws IOException {
		URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?id=" + id
				+ "&cnt=10&appid=44db6a862fba0b067b1930da0d769e98");

		URLConnection yc = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		StringBuilder b = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			b.append(inputLine);
		in.close();
		return new JSONObject(b.toString());

	}
}
