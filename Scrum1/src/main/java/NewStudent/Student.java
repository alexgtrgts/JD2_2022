package NewStudent;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Student {

    public static final int TIME = 66;
    public StudentStrategy strategy;

    protected double talant;
    private double razbor,paktika,potok,totalTime;
    private String name;

    public Student(String name, double talant,StudentStrategy strategy) {
        this.name = name;
        this.talant = talant;
        this.strategy = strategy;
    }

    public void executeCalculating() {
        strategy.calculateTotalTime(TIME, talant, name);
    }
}
