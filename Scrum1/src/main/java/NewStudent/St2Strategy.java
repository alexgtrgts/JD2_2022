package NewStudent;

public class St2Strategy implements StudentStrategy{

    private Student student;

    @Override
    public void calculateTotalTime(int time,double talent,String name) {
        double razbor = (time*2)/talent;
        double praktika = razbor;
        double potok = razbor;
        double totalTime = razbor + praktika + potok;
        System.out.println("Время на разбор у студента "+ name+" второй группы: " + razbor);
        System.out.println("Время на практику у студента "+name+" второй группы: " + praktika);
        System.out.println("Время на поток у студента "+name+" второй группы: " + potok);
        System.out.println("Время на полное освоение JAVA у студента "+name+" второй группы: " + totalTime);
    }
}
