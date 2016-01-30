package wednesday.codetester.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import wednesday.codetester.annotations.*;

public class Engine {
	private static final String PACKAGE = "wednesday.codetester";
	private static final Class<CodeTester> TEST_ANNOTATION = CodeTester.class;
	private static final Class<Before> BEFORE_ANNOTATION = Before.class;
	private static final Class<After> AFTER_ANNOTATION = After.class;

	public void run() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {

		// extract package metadata
		ClassMetaData metadata = new ClassMetaData(PACKAGE);

		// get annotated methods
		Set<Method> initMethods = metadata
				.getMethodsAnnotatedWith(BEFORE_ANNOTATION);
		Set<Method> testMethods = metadata
				.getMethodsAnnotatedWith(TEST_ANNOTATION);
		Set<Method> afterMethods = metadata
				.getMethodsAnnotatedWith(AFTER_ANNOTATION);

		Object obj = runMethods(initMethods);

		runMethods(testMethods, obj);
		runMethods(afterMethods, obj);
	}

	private Object runMethods(Set<Method> methods)
			throws InvocationTargetException {
		Object object = null;
		for (Method method : methods) {
			try {
				object = method.getDeclaringClass().newInstance();
				method.invoke(object);
				return object;
			} catch (InstantiationException | InvocationTargetException
					| IllegalAccessException | IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return object;

	}

	private void runMethods(Set<Method> methods, Object obj) {
		for (Method method : methods) {
			try {
				method.invoke(obj);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}
}
