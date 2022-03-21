package NewStudent;

import org.junit.Assert;
import org.junit.Test;

public class St1StrategyTest {

    final int TIME1 = 100;
    double talant = 0.5;
    double razbor1 = TIME1/talant;
    double praktika1 = razbor1;
    double potok1 = razbor1;

    @Test
    public void testCalculateTotalTime() {
        double totalTime1 = razbor1+praktika1+potok1;
        double razbor = TIME1 / talant;
        double praktika = razbor;
        double potok = razbor;
        double totalTime = razbor + praktika + potok;
        Assert.assertEquals(totalTime1,totalTime,0);
    }

}