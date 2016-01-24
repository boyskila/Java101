package wednesday.weatherapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class WheatherApi {
	private static JSONObject openConnection(long id) throws IOException {
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/forecast/daily?id="
						+ id + "&cnt=10&appid=44db6a862fba0b067b1930da0d769e98");
		try (InputStream stream = url.openStream();
				JsonReader r = Json.createReader(stream)) {
			return (JSONObject) r.readObject();
		}
		// URLConnection yc = yahoo.openConnection();
		// BufferedReader in = new BufferedReader(new InputStreamReader(
		// yc.getInputStream()));
		// String inputLine;
		// StringBuilder b = new StringBuilder();
		// while ((inputLine = in.readLine()) != null)
		// b.append(inputLine);
		// in.close();
		// return new JSONObject(b.toString());

	}

	public static void main(String[] args) throws IOException {
		// Tc = (Tf - 32) * (5 / 9)
		// Calendar cal = Calendar.getInstance();
		// URL yahoo = new URL(
		// "http://api.openweathermap.org/data/2.5/weather?q=London&appid=44db6a862fba0b067b1930da0d769e98");
		// URLConnection yc = yahoo.openConnection();
		// BufferedReader in = new BufferedReader(new InputStreamReader(
		// yc.getInputStream()));
		// String inputLine;
		// StringBuilder b = new StringBuilder();
		// while ((inputLine = in.readLine()) != null)
		// b.append(inputLine);
		// JSONObject ob = new JSONObject(b.toString());
		// System.out.println(ob);
		// JSONObject sys = new JSONObject(ob.get("sys").toString());
		// System.out.println("Time: " + cal.getTime());
		// System.out.println("Country: " + sys.get("country"));
		// System.out.println("City: " + ob.get("name"));
		// JSONArray weatherArray = new JSONArray(ob.get("weather").toString());
		// System.out.println("Description: "
		// + weatherArray.getJSONObject(0).get("description"));
		//
		// System.out
		// .println("Speed is: " + ob.getJSONObject("wind").get("speed"));
		// JSONObject main = ob.getJSONObject("main");
		// double max = (main.getDouble("temp") - 32) * 5 / 9;
		// System.out.println("Max temp: " + (int) max);
		List<String> cityes = Files.readAllLines(Paths.get("city.list.json"));
		for (String string : cityes) {
			JSONObject city = new JSONObject(string);
			if (city.get("name").equals("Sofia")) {
				System.out.println(city);
				JSONObject obj = openConnection(city.getLong("_id"));
				// System.out.println(obj.toString(4));
				JSONArray array = obj.getJSONArray("list");
				for (Object object : array) {
					JSONObject o = (JSONObject) object;
					JSONArray weather = (JSONArray) o.get("weather");
					System.out.println(weather.get(0));
					// System.out.println(o.get("dt"));

				}

			}

		}
		// in.close();
	}
}
