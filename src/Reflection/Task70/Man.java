package Reflection.Task70;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Man {

    String FirstName;
    String SecondName;
    int age;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void getAllInfo(Man man) {
        Field[] fields = man.getClass().getDeclaredFields();
        Method[] method = man.getClass().getDeclaredMethods();
        System.out.println("Поля класса: ");
        for (Field f:fields) {
            System.out.println(f.getName());
        }
        System.out.println("Методы класса: ");
        for (Method m:method) {
            System.out.println(m.getName());
        }
    }
}
