package wednesday.codetester;

import java.lang.reflect.InvocationTargetException;

import wednesday.codetester.api.Engine;

public class JunitApp {
	public static void main(String[] args) {
		try {
			new Engine().run();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
