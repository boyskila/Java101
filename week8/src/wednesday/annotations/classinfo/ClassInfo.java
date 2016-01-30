package wednesday.annotations.classinfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
	String getAuthor();

	int getRevision() default 1;

	boolean isChecked() default false;

	Class<?>[] getClasses();
}
