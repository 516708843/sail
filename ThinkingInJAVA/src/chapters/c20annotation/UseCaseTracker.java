package chapters.c20annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shift + (/)/{/} 跳到对应位置
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method method :
             cl.getDeclaredMethods() ) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (useCases != null) {
                System.out.println("Found use case"+useCases);
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (Integer integer :
                useCases) {
            System.out.println("Warning : Missing use case-" + integer);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PasswordUtil.class);
    }
}
