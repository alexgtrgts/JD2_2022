package Reflection.Task72;

import java.lang.reflect.Method;

public class Task72 {
    public static void main(String[] args) {
        MyAcademyInfo myAcademyInfo = new MyAcademyInfo();
        Method[] method = myAcademyInfo.getClass().getDeclaredMethods();

        for(Method m:method) {
            AcademyInfo academyInfo = m.getAnnotation(AcademyInfo.class);
            if (academyInfo !=null) {
                System.out.println("Метод " + m.getName() + " аннотирован");
            }
            else System.out.println("Метод " + m.getName() + " не аннотирован");
        }
    }
}
