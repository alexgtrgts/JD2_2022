package NewStudent;

public class St3Strategy implements StudentStrategy{

    private Student student;

    @Override
    public void calculateTotalTime(int time,double talent,String name) {
        double razbor = (time*3)/talent;
        double praktika = razbor;
        double potok = razbor;
        double totalTime = razbor + praktika + potok;
        System.out.println("Время на разбор у студента "+ name+" третьей группы: " + razbor);
        System.out.println("Время на практику у студента "+name+" третьей группы: " + praktika);
        System.out.println("Время на поток у студента "+name+" третьей группы: " + potok);
        System.out.println("Время на полное освоение JAVA у студента "+name+" третьей группы: " + totalTime);
    }
}
