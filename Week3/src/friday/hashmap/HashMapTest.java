package friday.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		MyHashMap<String, String> myHashMap = new MyHashMap<>();
		Map<String, String> m = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			m.put(i + "", "aa");
		}
		myHashMap.put("London", "lnd");
		// myHashMap.put("London", "LOOOOON");
		// myHashMap.put("London", "lnd");
		// myHashMap.put("Sofia", "Pesho");
		// myHashMap.put("Bansko", "Gosho");
		// myHashMap.put("Varna", "Pesho");
		// myHashMap.put("Pleven", "Minko");
		// myHashMap.put("Burgas", "Boyan");
		// myHashMap.put("Vraca", "Ginka");
		// myHashMap.put("NUll", null);
		myHashMap.put("Pirdop", "pir");
		myHashMap.put("Zlatica", "zla");
		myHashMap.put("Samokov", "sam");
		myHashMap.put("Razgrad", "raz");
		// System.out.println(myHashMap);
		myHashMap.put("Plovdiv", "plv");
		// System.out.println(myHashMap);
		myHashMap.put("Lukovit", "luk");
		// System.out.println(myHashMap);
		myHashMap.put("Ruse", "rus");
		// System.out.println(myHashMap);
		myHashMap.put("Vidin", "vid");
		myHashMap.put("Berlin", "ber");
		myHashMap.put("Madrid", "mad");
		myHashMap.put("Paris", "par");
		// myHashMap.putAll(m);
		myHashMap.put("2", "abc");
		System.out.println(myHashMap.remove("Sofia"));
		System.out.println(myHashMap);
		System.out.println(myHashMap.containsKey(null));
		System.out.println(myHashMap.size());
		// myHashMap.clear();
		List<String> l = new ArrayList<>();
		Iterator<String> it = myHashMap.keySet().iterator();
		while (it.hasNext()) {
			String string = it.next();
			l.add(string);
		}

		System.out.println(myHashMap.get("Vidin"));
		System.out.println(myHashMap.size());
		System.out.println(l);
		// while (!myHashMap.isEmpty()) {
		// myHashMap.remove(l.get(c));
		// c++;
		// }

		System.out.println(myHashMap);
		// System.out.println(myHashMap.entrySet());
		for (String string : myHashMap.keySet()) {
			System.out.println(string);
		}
		for (String string : myHashMap.keySet()) {
			System.out.println(string);
		}
	}
}
