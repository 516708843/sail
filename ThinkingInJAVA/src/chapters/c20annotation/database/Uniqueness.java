package chapters.c20annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique=true);
}
