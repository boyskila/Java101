package com.boyko.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

@Path("/id/")
public class RestExample {

	@GET
	@Path("{cityId}")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(@PathParam("cityId") String cityId)
			throws NumberFormatException, IOException, URISyntaxException {

		JSONObject json = getJson(Long.parseLong(cityId));
		System.out.println(json.toString(4));
		 System.out.println(json.toString(4));
		// File f = new File("NewFile.html");
		// System.out.println(new File("."));
		 URL resource = RestExample.class.getResource("NewFile.html");
		 System.out.println(Paths.get(resource.toURI()).toFile());
		 //return new FileInputStream(f);
		return json.toString();
	}

	private JSONObject getJson(long id) throws IOException {
		URL yahoo = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?id=" + id
				+ "&cnt=10&appid=44db6a862fba0b067b1930da0d769e98");
		URLConnection yc = yahoo.openConnection();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
			String inputLine;
			StringBuilder b = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				b.append(inputLine);
			}
			return new JSONObject(b.toString());
		}

	}

}
