package Reflection.Task70;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task70 {
    public static void main(String[] args) {
        Man man = new Man();
        Method method;
        try {
            method = man.getClass().getDeclaredMethod("getAllInfo", Man.class);
            method.invoke(man, man);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
