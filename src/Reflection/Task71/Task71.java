package Reflection.Task71;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task71 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello hello = new Hello();
        Method m = hello.getClass().getDeclaredMethod("printHello",null);
        m.invoke(hello,null);
    }
}
