import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class DuplicateRemovalTest {

    DigitalIO digitalIO = new DigitalIO();

    @Test
    @DisplayName("Checking random value")
    public void randomValueTest() {

        int randVal = digitalIO.randomValue.nextInt(2);

        if (randVal == 0) {
            Assertions.assertEquals(0, randVal);
        } else {
            Assertions.assertEquals(1, randVal);
        }
    }

    @Test
    @DisplayName("Checking random time")
    public void randomTimeTest() {

        int randTime = digitalIO.randomTime.nextInt(digitalIO.upperBoundary- digitalIO.lowerBoundary) + digitalIO.lowerBoundary;

        Assertions.assertTrue(randTime >= digitalIO.lowerBoundary && randTime <= digitalIO.upperBoundary);
    }

    @Test
    @DisplayName("Checking timestamp")
    public void timestampTest() {

        long timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

        Assertions.assertTrue(timestamp > 0 && timestamp <	2147472000 );
        // 	2147472000 - is a 19.01.2038, on this date the Unix Time Stamp will cease to work due to a 32-bit overflow.
    }
}
