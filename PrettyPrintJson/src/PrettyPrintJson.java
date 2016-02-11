

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/*
 * This servlet will pretty print this json, just put it as url parameter
 * 
 * http://localhost:8080/jsonprint/pretty?json={%22coord%22:{%22lon%22:139,%22lat%22:35},%22sys%22:{%22country%22:%22JP%22,%22sunrise%22:1369769524,%22sunset%22:1369821049},%22weather%22:[{%22id%22:804,%22main%22:%22clouds%22,%22description%22:%22overcast%20clouds%22,%22icon%22:%2204n%22}],%22main%22:{%22temp%22:289.5,%22humidity%22:89,%22pressure%22:1013,%22temp_min%22:287.04,%22temp_max%22:292.04},%22wind%22:{%22speed%22:7.31,%22deg%22:187.002},%22rain%22:{%223h%22:0},%22clouds%22:{%22all%22:92},%22dt%22:1369824698,%22id%22:1851632,%22name%22:%22Shuzenji%22,%22cod%22:200}
 * 
 * {"coord":{"lon":139,"lat":35},
"sys":{"country":"JP","sunrise":1369769524,"sunset":1369821049},
"weather":[{"id":804,"main":"clouds","description":"overcast clouds","icon":"04n"}],
"main":{"temp":289.5,"humidity":89,"pressure":1013,"temp_min":287.04,"temp_max":292.04},
"wind":{"speed":7.31,"deg":187.002},
"rain":{"3h":0},
"clouds":{"all":92},
"dt":1369824698,
"id":1851632,
"name":"Shuzenji",
"cod":200}
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/pretty")
public class PrettyPrintJson extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter p = response.getWriter();
		response.setContentType("text/json");

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(request.getParameter("json"));
		String prettyJsonString = gson.toJson(je);

		p.write(prettyJsonString);
		// or just request.getParameter("json").toString(4); do the same thing
		p.close();
	}
}
