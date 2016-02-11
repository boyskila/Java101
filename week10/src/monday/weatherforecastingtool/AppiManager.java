package monday.weatherforecastingtool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

//2643743
public class AppiManager {
	private static final Path CITI_LIST = Paths.get("city.list.json");

	private static JSONObject apiConnection(long id) throws IOException {
		URL yahoo = new URL(
				"http://api.openweathermap.org/data/2.5/forecast/daily?id="
						+ id + "&cnt=10&appid=44db6a862fba0b067b1930da0d769e98");
		URLConnection yc = yahoo.openConnection();
		StringBuilder jsonBuilder = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				jsonBuilder.append(inputLine);
			}
		}
		return new JSONObject(jsonBuilder.toString());

	}

	public static long getCity(String cityName) throws IOException {
		List<String> cities = Files.readAllLines(CITI_LIST);
		for (String string : cities) {
			JSONObject city = new JSONObject(string);
			if (((String) city.getString("name")).equalsIgnoreCase(cityName)) {
				System.out.println(cityName);
				return city.getLong("_id");
			}
		}
		return 0;
	}

	public static void main(String[] args) throws JSONException, IOException {
		String name = "Sofia";
		System.out.println(getCity(name));
		System.out.println(apiConnection(getCity(name)).toString(4));

		// List<String> cities = Files.readAllLines(CITI_LIST);
		// List<JSONObject> objects = new ArrayList<>();
		// for (String string : cities) {
		// JSONObject city = new JSONObject(string);
		// objects.add(city);
		// if (city.get("name").equals("London")) {
		// System.out.println(city);
		// JSONObject obj = openConnection(city.getLong("_id"));
		// System.out.println(obj.toString(4));
		// // System.out.println(obj.getJSONArray(""));
		// JSONArray array = obj.getJSONArray("list");
		// for (Object object : array) {
		// JSONObject o = (JSONObject) object;
		// System.out.println(new Date(1446533902));
		// JSONArray weather = (JSONArray) o.get("weather");
		// System.out.println(weather.get(0));
		// System.out.println(o.get("dt"));
		// }
		// }
		//
		// Collections.sort(objects, new Comparator<JSONObject>() {
		// @Override
		// public int compare(JSONObject o1, JSONObject o2) {
		// Long city1 = Long.parseLong(o1.getString("_id").trim());
		// Long city2 = Long.parseLong(o2.getString("_id").trim());
		// return city1.compareTo(city2);
		// }
		// });
		// int index = Collections.binarySearch(objects, 2643743, null);
		// System.out.println(index);
	}
}
