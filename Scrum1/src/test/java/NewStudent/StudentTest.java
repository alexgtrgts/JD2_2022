package NewStudent;


import org.junit.Test;

public class StudentTest {

    StudentStrategy strategy = new St2Strategy();
    public final int TIME1 = 100;
    public double talent = 1;


    @Test
    public void testExecuteCalculating() {
        strategy.calculateTotalTime(TIME1, talent, "is running");
    }
}