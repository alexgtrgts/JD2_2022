package NewStudent;

public class St1Strategy implements StudentStrategy {

    private Student student;

    @Override
    public void calculateTotalTime(int time, double talent, String name) {
        double razbor = time/talent;
        double praktika = razbor;
        double potok = razbor;
        double totalTime = razbor + praktika + potok;
        System.out.println("Время на разбор у студента "+name+" первой группы: " + razbor);
        System.out.println("Время на практику у студента "+name+" первой группы: " + praktika);
        System.out.println("Время на поток у студента "+name+" первой группы: " + potok);
        System.out.println("Время на полное освоение JAVA у студента "+name+" первой группы: " + totalTime);
    }
}
