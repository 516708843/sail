package chapters.c20annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//TODO 不加@Retention,反射时获取不到加了这个注解的属性
public @interface SQLInteger {

    String name() default "";
    Constraints constraints() default @Constraints;

}
