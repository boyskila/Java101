package wednesday.annotations.classinfo;

import java.lang.annotation.Annotation;

public class InfoApp {
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Annotation[] annotations = Info.class.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
	}

}
